package com.selfproject.fxratesapp.emailalertservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailAlertService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public EmailAlertService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmailAlert(String message) throws MailException{
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("wohootestemail123@gmail.com");
		simpleMailMessage.setFrom("wohootestemail123@gmail.com");
		simpleMailMessage.setSubject("test mail: shopping time!!");
		simpleMailMessage.setText(message);
		
		javaMailSender.send(simpleMailMessage);
	}
}
