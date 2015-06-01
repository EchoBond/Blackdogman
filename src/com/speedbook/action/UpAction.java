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
	//获取上传文件,名称必须和表单file控件名相同-->       
    private File uploadfile;  

    //获取上传文件名,命名格式：表单file控件名+FileName(固定)-->      
    private String uploadfileFileName;  

    //获取上传文件类型,命名格式：表单file控件名+ContentType(固定)   
    private String uploadfileContentType;       
    
    private UpDao upDao;
    @Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return upload();
	}  

    public String upload() throws IOException  
    {  
            //设置上传文件目录    
            String realpath = ServletActionContext.getServletContext().getRealPath("/File");  

            //判断上传文件是否为空      
            if(uploadfile!=null)  
            {  
                    //设置目标文件（根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例）  
                    File savefile = new File(realpath,uploadfileFileName);  

                    // 判断上传目录是否存在            
                    if(!savefile.getParentFile().exists())  
                          savefile.getParentFile().mkdirs();  

                    FileUtils.copyFile(uploadfile,savefile);  

                    //设置request对象值       
                    ActionContext.getContext().put("message", "上传成功！");  
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
