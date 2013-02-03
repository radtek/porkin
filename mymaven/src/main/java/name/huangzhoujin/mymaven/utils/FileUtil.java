package name.huangzhoujin.mymaven.utils;

import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;

import name.huangzhoujin.mymaven.persistence.domain.Repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {

	private static Log log = LogFactory.getLog(FileUtil.class);
	
	public static final String READ_WRITE = "rw";

	public static boolean writeLink(String fileName, String linkStr) {
		boolean result = true;
		try {
			RandomAccessFile myFileStream = new RandomAccessFile(fileName, READ_WRITE);
			myFileStream.seek(myFileStream.length());
			myFileStream.writeBytes(linkStr + "\r\n");
			myFileStream.close();
		} catch (Exception e) {
			log.warn("Warning:" + e.getMessage());
			result = false;
		}
		return result;
	}
	
	public static boolean batchWriteLink(String fileName, List<String> linkStr) {
		boolean result = true;
		try {
			RandomAccessFile myFileStream = new RandomAccessFile(fileName, READ_WRITE);
			myFileStream.seek(myFileStream.length());
			Iterator<String> iter = linkStr.iterator();
			String link;
			while(iter.hasNext()){
				link = iter.next();
				myFileStream.writeBytes(link + "\r\n");
			}
			
			myFileStream.close();
		} catch (Exception e) {
			log.warn("Warning:" + e.getMessage());
			result = false;
		}
		return result;
	}
	
	public static void exportByRange(int from, int to ){
		List<Repository> list = ServiceFacade.getRepositoryService().loadRepositoryByRange(from, to);
		Iterator<Repository> iter = list.iterator();
		String url;
		Repository repository;
		while(iter.hasNext()){
			repository = iter.next();
			url = repository.getRepUrl();
			FileUtil.writeLink(HttpUtil.getFileName(), url);
		}
		log.info("Export file successfully from " + from +" to "+ to);
	}

}
