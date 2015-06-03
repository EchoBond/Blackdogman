package com.speedbook.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.speedbook.dao.UpDao;
import com.speedbook.service.UpService;

public class UpAction extends ActionSupport {
	//��ȡ�ϴ��ļ�           ���Ʊ���ͱ�file�ؼ�����ͬ-->       
    private File uploadfile;  
    //��ȡ�ϴ��ļ���       ������ʽ����file�ؼ���+FileName(�̶�)-->      
    private String uploadfileFileName;  
    //��ȡ�ϴ��ļ�����    ������ʽ����file�ؼ���+ContentType(�̶�)   
    private String uploadfileContentType; 
    private UpService upService;
    
    @Override
	public String execute() throws Exception {
    	String areyouok=upService.upload(uploadfile,uploadfileFileName,uploadfileContentType);
    	return areyouok;
	}  

     public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

	public UpService getUpService() {
		return upService;
	}

	public void setUpService(UpService upService) {
		this.upService = upService;
	}

}
