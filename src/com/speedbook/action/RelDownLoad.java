package com.speedbook.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RelDownLoad extends ActionSupport {

	//�ó�Ա���������������ļ��ж�̬�ƶ���ֵ
	private String inputPath;
	
	public InputStream getTargetFile() throws Exception{
		return ServletActionContext.getServletContext()
						.getResourceAsStream(inputPath);
	}
	
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
}
