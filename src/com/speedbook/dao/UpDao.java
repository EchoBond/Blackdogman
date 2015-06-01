package com.speedbook.dao;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class UpDao {
	//��ȡ�ϴ��ļ�,���Ʊ���ͱ�file�ؼ�����ͬ-->       
    private File uploadfile;  

    //��ȡ�ϴ��ļ���,������ʽ����file�ؼ���+FileName(�̶�)-->      
    private String uploadfileFileName;  

    //��ȡ�ϴ��ļ�����,������ʽ����file�ؼ���+ContentType(�̶�)   
    private String uploadfileContentType; 
    
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
  	
  	
}
