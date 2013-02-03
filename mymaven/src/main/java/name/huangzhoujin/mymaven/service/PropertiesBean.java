package name.huangzhoujin.mymaven.service;

import java.util.ArrayList;
import java.util.List;

import name.huangzhoujin.mymaven.utils.spring.Property;

import org.springframework.stereotype.Repository;

@Repository
public class PropertiesBean {

	private String repository;

	private String proxyEnable;
	private String proxyHost;
	private String proxyPort;
	private String proxyProtocol;
	private String targetFile;

	private String fileEnable;
	private String databaseEnable;

	private String downloadCount;
	private String downloadFolder;
	private String downloadWget;
	private String downloadFilter;
	private String downloadAppend;

	public String getRepository() {
		return repository;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public String getProxyProtocol() {
		return proxyProtocol;
	}

	public String getTargetFile() {
		return targetFile;
	}

	public String getProxyEnable() {
		return proxyEnable;
	}

	public String getFileEnable() {
		return fileEnable;
	}

	public String getDatabaseEnable() {
		return databaseEnable;
	}

	public String getDownloadCount() {
		return downloadCount;
	}

	public String getDownloadFolder() {
		return downloadFolder;
	}

	public String getDownloadWget() {
		return downloadWget;
	}

	public List<String> getDownloadFilterList() {
		List<String> result = new ArrayList<String>();
		String[] filterArray = getDownloadFilter().split(",");
		for (String temp : filterArray) {
			result.add(temp);
		}
		return result;
	}

	public List<String> getDownloadAppendList() {
		List<String> result = new ArrayList<String>();
		String[] appendArray = getDownloadAppend().split(",");
		for (String temp : appendArray) {
			result.add(temp);
		}
		return result;
	}

	public String getDownloadAppend() {
		return downloadAppend;
	}

	@Property(key = "download.append", defaultValue = "org,com")
	public void setDownloadAppend(String downloadAppend) {
		this.downloadAppend = downloadAppend;
	}

	public String getDownloadFilter() {
		return downloadFilter;
	}

	@Property(key = "download.filter", defaultValue = "zip,gz,war,bz,bz2")
	public void setDownloadFilter(String downloadFilter) {
		this.downloadFilter = downloadFilter;
	}

	@Property(key = "download.wget", defaultValue = "wget -c -r -np -k -L -p ")
	public void setDownloadWget(String downloadWget) {
		this.downloadWget = downloadWget;
	}

	@Property(key = "download.folder", defaultValue = "/opt/maven")
	public void setDownloadFolder(String downloadFolder) {
		this.downloadFolder = downloadFolder;
	}

	@Property(key = "download.count", defaultValue = "1000")
	public void setDownloadCount(String downloadCount) {
		this.downloadCount = downloadCount;
	}

	@Property(key = "file.storage.enable", defaultValue = "true")
	public void setFileEnable(String fileEnable) {
		this.fileEnable = fileEnable;
	}

	@Property(key = "db.storage.enable", defaultValue = "true")
	public void setDatabaseEnable(String databaseEnable) {
		this.databaseEnable = databaseEnable;
	}

	@Property(key = "proxy.enable", defaultValue = "true")
	public void setProxyEnable(String proxyEnable) {
		this.proxyEnable = proxyEnable;
	}

	@Property(key = "repository", defaultValue = "http://repository.sonatype.org/content/groups/public/")
	public void setRepository(String repository) {
		this.repository = repository;
	}

	@Property(key = "proxy.host", defaultValue = "58.2.221.9")
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	@Property(key = "proxy.port", defaultValue = "80")
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	@Property(key = "proxy.protocol", defaultValue = "http")
	public void setProxyProtocol(String proxyProtocol) {
		this.proxyProtocol = proxyProtocol;
	}

	@Property(key = "target.file", defaultValue = "/opt/maven_repository.txt")
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}

}
