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
	//获取上传文件           名称必须和表单file控件名相同-->       
    private File uploadfile;  
    //获取上传文件名       命名格式：表单file控件名+FileName(固定)-->      
    private String uploadfileFileName;  
    //获取上传文件类型    命名格式：表单file控件名+ContentType(固定)   
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
