package lv.venta.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingServiceImpl {

	@Autowired
	private JavaMailSender mailSender;
	
	
	public void sendSimpleMsg(String toEmail, String fromEmail,
			String subject, String text, File attachment) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromEmail);
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(text);
		//TODO pieveinot epastam attachemnt
		
		mailSender.send(msg);
		
	}
	
}
