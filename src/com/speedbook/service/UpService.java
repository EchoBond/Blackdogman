package com.speedbook.service;

import java.io.File;
import java.io.IOException;

import com.speedbook.dao.UpDao;

public class UpService {
	UpDao updao;

	public String upload(File uploadfile,String uploadfileFileName,String uploadfileContentType) throws IOException{
		String areyouok=updao.upload(uploadfile,uploadfileFileName,uploadfileContentType);
		return areyouok;
	}
	public UpDao getUpdao() {
		return updao;
	}

	public void setUpdao(UpDao updao) {
		this.updao = updao;
	}
	
}
