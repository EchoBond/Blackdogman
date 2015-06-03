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
	//��ȡ�ϴ��ļ�           ���Ʊ���ͱ�file�ؼ�����ͬ-->       
    private File uploadfile;  
    //��ȡ�ϴ��ļ���       ������ʽ����file�ؼ���+FileName(�̶�)-->      
    private String uploadfileFileName;  
    //��ȡ�ϴ��ļ�����    ������ʽ����file�ؼ���+ContentType(�̶�)   
    private String uploadfileContentType; 
    
    private SessionFactory sf;
	private Session sess;
	private Transaction tx;
	
	//���ڻ�ȡhibernate����
		public void getSession(){
			sess=sf.openSession();
			tx=sess.beginTransaction();
		}
		//ִ�в���������
		public void distroy(){
			tx.commit();
			sess.close();
			sf.close();
		}
	
    public String upload(File uploadfile,String uploadfileFileName,String uploadfileContentType) throws IOException  
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
