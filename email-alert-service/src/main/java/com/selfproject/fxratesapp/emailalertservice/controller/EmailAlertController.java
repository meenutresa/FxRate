package com.selfproject.fxratesapp.emailalertservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.selfproject.fxratesapp.emailalertservice.service.EmailAlertService;

@RestController
public class EmailAlertController {
	
	@Autowired
	EmailAlertService emailAlertService;
	
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public String sendEmail(@RequestBody String message) {
		System.out.println(message);
		try {
			emailAlertService.sendEmailAlert(message);
		}
		catch(MailException ex) {
			System.out.println(ex);
		}
		return "email sent successfully";
	}
	

}
