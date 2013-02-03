package name.huangzhoujin.mymaven.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import name.huangzhoujin.mymaven.persistence.domain.Repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);

	private static String proxyHost;
	private static int proxyPort;
	private static String proxyProtocol;
	private static String fileName = null;

	private static HttpHost proxy = null;

	private static Boolean proxyEnable = null;
	private static Boolean fileEnable = null;
	private static Boolean databaseEnable = null;

	private static List<String> topList = null;
	private static List<String> usedTopFolderList = null;
	private static List<String> unusedList = null;

	public static List<String> getTopList() {
		if (topList == null) {
			String url = ServiceFacade.getPropertiesBean().getRepository();
			topList = extactTop(url);
		}
		return topList;
	}

	public static List<String> getUsedTopFolderList() {
		if (usedTopFolderList == null) {
			usedTopFolderList = new ArrayList<String>();
			int len = ServiceFacade.getPropertiesBean().getRepository()
					.length() + 2;
			List<String> list = ServiceFacade.getCustomService()
					.getRepositoryTopList(len);
			Iterator<String> iter = list.iterator();
			String url;
			while (iter.hasNext()) {
				url = iter.next();
				if (isFolder(url)) {
					usedTopFolderList.add(url);
				}
			}
		}
		return usedTopFolderList;
	}

	public static List<String> getUnusedList() {
		if (unusedList == null) {
			unusedList = new ArrayList<String>();
			List<String> topList = getTopList();
			List<String> unusedTopList = getUsedTopFolderList();
			topList.removeAll(unusedTopList);

			Iterator<String> iter = topList.iterator();
			String url;
			while (iter.hasNext()) {
				url = iter.next();
				if (isFolder(url)) {
					unusedList.add(url);
				}
			}

			// Append folder
			List<String> appendList = ServiceFacade.getPropertiesBean()
					.getDownloadAppendList();
			iter = appendList.iterator();
			while (iter.hasNext()) {
				url = iter.next();
				unusedList.add(ServiceFacade.getPropertiesBean()
						.getRepository() + url + Constants.SLASH_STRING);
			}
		}

		return unusedList;
	}

	public static boolean isUnusedList(String r) {
		boolean result = false;
		List<String> unusedList = getUnusedList();
		Iterator<String> iter = unusedList.iterator();
		String unusedLink;
		while (iter.hasNext()) {
			unusedLink = iter.next();
			if (r.startsWith(unusedLink)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static Boolean getProxyEnable() {
		if (proxyEnable == null) {
			proxyEnable = Boolean.parseBoolean(ServiceFacade
					.getPropertiesBean().getProxyEnable());
		}
		return proxyEnable;
	}

	public static Boolean getFileEnable() {
		if (fileEnable == null) {
			fileEnable = Boolean.parseBoolean(ServiceFacade.getPropertiesBean()
					.getFileEnable());
		}
		return fileEnable;
	}

	public static Boolean getDatabaseEnable() {
		if (databaseEnable == null) {
			databaseEnable = Boolean.parseBoolean(ServiceFacade
					.getPropertiesBean().getDatabaseEnable());
		}
		return databaseEnable;
	}

	public static HttpHost getProxy() {
		if (proxy == null) {
			proxyHost = ServiceFacade.getPropertiesBean().getProxyHost();
			proxyPort = Integer.parseInt(ServiceFacade.getPropertiesBean()
					.getProxyPort());
			proxyProtocol = ServiceFacade.getPropertiesBean()
					.getProxyProtocol();
			proxy = new HttpHost(proxyHost, proxyPort, proxyProtocol);
		}
		return proxy;
	}

	public static void setProxyHost(String proxyHost) {
		HttpUtil.proxyHost = proxyHost;
	}

	public static String getProxyHost() {
		return proxyHost;
	}

	public static void setProxyPort(int proxyPort) {
		HttpUtil.proxyPort = proxyPort;
	}

	public static void setProxyProtocol(String proxyProtocol) {
		HttpUtil.proxyProtocol = proxyProtocol;
	}

	public static String getFileName() {
		if (fileName == null) {
			fileName = ServiceFacade.getPropertiesBean().getTargetFile();
		}
		return fileName;
	}

	public static List<String> getLinkList(String inputHtml) {
		List<String> result = new ArrayList<String>();
		try {
			Parser parser = Parser.createParser(new String(
					inputHtml.getBytes(), "UTF-8"), "UTF-8");
			NodeFilter filter = new NodeClassFilter(LinkTag.class);
			parser.setEncoding(parser.getEncoding());
			NodeList list = parser.extractAllNodesThatMatch(filter);
			for (int i = 0; i < list.size(); i++) {
				LinkTag node = (LinkTag) list.elementAt(i);
				result.add(node.extractLink());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getHtmlText(String url) {
		String result = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			log.info("Executing request without proxy " + httpget.getURI());
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = httpclient.execute(httpget, responseHandler);
			result = responseBody.toString();
		} catch (Exception e) {
			log.warn("Warning:" + e.getMessage());
			result = "Connection error!";
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	public static String getHtmlTextWithProxy(String url) {
		String result = null;
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,
					getProxy());
			HttpGet httpget = new HttpGet(url);
			log.info("executing request with Proxy" + httpget.getURI());
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			String responseBody = httpclient.execute(httpget, responseHandler);
			result = responseBody.toString();
		} catch (Exception e) {
			log.warn("Warning:" + e.getMessage());
			result = "Connection error!";
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return result;
	}

	public static List<String> extactTop(String url) {
		HttpUtil.setProxyHost(getProxyHost());
		HttpUtil.setProxyProtocol(ProtocolType.Http.getType());
		HttpUtil.setProxyPort(ProtocolType.Http.getDefaultPort());

		String htmlText = null;
		if (getProxyEnable()) {
			htmlText = HttpUtil.getHtmlTextWithProxy(url);
		} else {
			htmlText = HttpUtil.getHtmlText(url);
		}
		List<String> linkList = getLinkList(htmlText);
		return linkList;
	}

	public static List<String> exactAll(String url) {
		List<String> result = new ArrayList<String>();

		HttpUtil.setProxyHost(getProxyHost());
		HttpUtil.setProxyProtocol(ProtocolType.Http.getType());
		HttpUtil.setProxyPort(ProtocolType.Http.getDefaultPort());

		String htmlText = null;
		if (getProxyEnable()) {
			htmlText = HttpUtil.getHtmlTextWithProxy(url);
		} else {
			htmlText = HttpUtil.getHtmlText(url);
		}

		List<String> linkList = getLinkList(htmlText);
		Iterator<String> iter = linkList.iterator();
		String link;
		while (iter.hasNext()) {
			link = iter.next();
			if (isFolder(link)) {
				if (!isUnusedList(link)) {
					log.info("Ignore the url>>>" + link);
					continue;
				}
				List<String> folderLists = exactAll(link);
				Iterator<String> it = folderLists.iterator();
				while (it.hasNext()) {
					result.add(it.next());
				}
			} else {
				result.add(link);
				if (getFileEnable()) {
					log.info("File recording >>>" + link);
					FileUtil.writeLink(getFileName(), link);
				}

				if (getDatabaseEnable()) {
					log.info("Database recording >>>" + link);
					boolean successFlag = ServiceFacade.getRepositoryService()
							.create(link);
					if (successFlag) {
						log.info("Database recording >>>" + link
								+ " is created successfully!");
					} else {
						log.info("Database recording >>>" + link
								+ " is failure to create!");
					}
				}

			}
		}
		return result;
	}

	public static void downloadByCount(int count) {
		int from = 1;
		int to = Integer.MAX_VALUE;

		if (count != Constants.NUMBER_ZERO) {
			Long beginId = ServiceFacade.getCustomService()
					.getMinUnusedRepositoryID();
			if (beginId == null) {
				from = 1;
			} else {
				from = beginId.intValue();
			}
			to = from + count;
		}

		String url = null;
		boolean successFlag = false;
		for (int i = from; i <= to; i++) {
			Repository r = ServiceFacade.getRepositoryService()
					.loadByUnusedAndId(i);
			if (r != null) {
				url = r.getRepUrl();
				if (!isFilter(url) && executeWget(url)) {
					r.setUsedFlag(Constants.USED_FLAG_YES);
					r.setLastUpdated(new Date());
					successFlag = ServiceFacade.getRepositoryService()
							.update(r);
					if (successFlag) {
						log.info(url + " is dowloaded successfully!");
					} else {
						log.info(url + " is failure to downlaoding!");
					}
				}
			}
		}
	}

	public static boolean isFilter(String url) {
		boolean result = false;
		List<String> filterList = ServiceFacade.getPropertiesBean()
				.getDownloadFilterList();
		for (String filter : filterList) {
			if (url.endsWith(filter)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static boolean isTop(String url) {
		boolean result = false;
		List<String> list = getTopList();
		Iterator<String> iter = list.iterator();
		String link;
		while (iter.hasNext()) {
			link = iter.next();
			if (url.startsWith(link)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static boolean executeWget(String url) {
		boolean result = false;
		Process pid = null;
		String wgetCmd = ServiceFacade.getPropertiesBean().getDownloadWget();
		try {
			String[] cmd = { wgetCmd, url };
			pid = Runtime.getRuntime().exec(cmd);
			if (pid != null) {
				log.info("Process Id :" + pid.toString());
				pid.waitFor();
				result = true;
			}
		} catch (Exception e) {
			log.info("Exception of executeWget:" + e.getMessage());
			result = false;
		}

		return result;
	}

	public static boolean isFolder(String url) {
		boolean result = false;
		if (url.endsWith(Constants.SLASH_STRING)) {
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
//		List<String> list = getUnusedList();
//		Iterator<String> iter = list.iterator();
//		String url = null;
//		while (iter.hasNext()) {
//			url = iter.next();
//			System.out.println(">>>" + url);
//		}
	}

}
