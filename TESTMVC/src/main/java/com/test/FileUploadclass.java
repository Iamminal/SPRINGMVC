package com.test;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadclass {
	
	public static final String SAVE_LOCATION="D:/SHARING/";
	 public boolean savefile(CommonsMultipartFile file) throws IllegalStateException, IOException
	 {
		 boolean result=false;
		 File pathfile=new File(SAVE_LOCATION);
			if(!pathfile.exists()){
	            pathfile.mkdir();
	        }
			pathfile=new File(SAVE_LOCATION+file.getOriginalFilename());
			file.transferTo(pathfile);
		 
		return result;
		 
	 }
	

}
