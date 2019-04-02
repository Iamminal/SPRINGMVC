package com.test;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class MVController1 {
	@Autowired
	private JavaMailSender mailSender;
	
	private String saveDirectory = "D:/SHARING/upload/";
	
	FileUploadclass uploadmy=new FileUploadclass();

	@RequestMapping(value="/sendit")
	public String sendanmail(Model model)
	{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo("biswan8@gmail.com");
		mail.setSubject("TEST MAIL");
		mail.setText("Khawar bana bhai");
		mailSender.send(mail);
		
		return "Sucess";
		
	}
	
	@RequestMapping(value="/upload")
	public String redirecttouploadPage(Model m)
	{
	return "upload";
	}
	
	/*@RequestMapping(value="/uploadmy", method=RequestMethod.POST)
	public String uploadafile(@RequestParam("file") MultipartFile multipartFile)
	{
		System.out.println(multipartFile.getOriginalFilename()+" "+multipartFile.getSize());
		if(multipartResolver.savefile(multipartFile))
		{
			return "upload-success";
		}
		return "upload-failure";
	}*/
	
	@RequestMapping(value="/uploadmy",method=RequestMethod.POST)
	public String savefile(@RequestParam CommonsMultipartFile file) throws  IOException
	{
		uploadmy.savefile(file);
		
		
		return "upload-success";
		
	}

}
