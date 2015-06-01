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

public class UpAction extends ActionSupport {
	//��ȡ�ϴ��ļ�,���Ʊ���ͱ�file�ؼ�����ͬ-->       
    private File uploadfile;  

    //��ȡ�ϴ��ļ���,������ʽ����file�ؼ���+FileName(�̶�)-->      
    private String uploadfileFileName;  

    //��ȡ�ϴ��ļ�����,������ʽ����file�ؼ���+ContentType(�̶�)   
    private String uploadfileContentType;       
    
    private UpDao upDao;
    @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return upload();
	}  

    public String upload() throws IOException  
    {  
            //�����ϴ��ļ�Ŀ¼    
            String realpath = ServletActionContext.getServletContext().getRealPath("/File");  

            //�ж��ϴ��ļ��Ƿ�Ϊ��      
            if(uploadfile!=null)  
            {  
                    //����Ŀ���ļ������� parent ·�����ַ����� child ·�����ַ�������һ���� File ʵ����  
                    File savefile = new File(realpath,uploadfileFileName);  

                    // �ж��ϴ�Ŀ¼�Ƿ����            
                    if(!savefile.getParentFile().exists())  
                          savefile.getParentFile().mkdirs();  

                    FileUtils.copyFile(uploadfile,savefile);  

                    //����request����ֵ       
                    ActionContext.getContext().put("message", "�ϴ��ɹ���");  
            }  
            return "success";  
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

	public UpDao getUpDao() {
		return upDao;
	}

	public void setUpDao(UpDao upDao) {
		this.upDao = upDao;
	}
	
	
}
