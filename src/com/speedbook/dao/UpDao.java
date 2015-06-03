package com.speedbook.dao;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.speedbook.model.Upload;

public class UpDao {
	//获取上传文件           名称必须和表单file控件名相同-->       
    private File uploadfile;  
    //获取上传文件名       命名格式：表单file控件名+FileName(固定)-->      
    private String uploadfileFileName;  
    //获取上传文件类型    命名格式：表单file控件名+ContentType(固定)   
    private String uploadfileContentType; 
    
    private SessionFactory sf;
	private Session sess;
	private Transaction tx;
	
	//用于获取hibernate链接
		public void getSession(){
			sess=sf.openSession();
			tx=sess.beginTransaction();
		}
		//执行并销毁链接
		public void distroy(){
			tx.commit();
			sess.close();
			sf.close();
		}
	
    public String upload(File uploadfile,String uploadfileFileName,String uploadfileContentType) throws IOException  
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

                    Upload upload=new Upload();
                    upload.setName(uploadfileFileName);
                    upload.setUri(realpath);
                    getSession();
                    sess.save(upload);
                    distroy();
            }  
            return "success";  
     }
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	
}
