package net.cominfo.digiagent.utils;

import net.cominfo.digiagent.spring.iface.Property;

import org.springframework.stereotype.Repository;

@Repository
public class PropertiesBean {

	private String uploadFileRoot;
	private String uploadFileFolder;

	public String getUploadFileRoot() {
		return uploadFileRoot;
	}

	@Property(key = "upload.file.root", defaultValue = "C:")
	public void setUploadFileRoot(String uploadFileRoot) {
		this.uploadFileRoot = uploadFileRoot;
	}

	public String getUploadFileFolder() {
		return uploadFileFolder;
	}

	@Property(key = "upload.file.folder", defaultValue = "Temp1")
	public void setUploadFileFolder(String uploadFileFolder) {
		this.uploadFileFolder = uploadFileFolder;
	}

}
