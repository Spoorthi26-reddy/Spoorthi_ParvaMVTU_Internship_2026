package com.example.emailregistration.service;

//import com.example.emailregistration.model.User;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.*;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//
//@Service
//public class EmailService {
//
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private SpringTemplateEngine templateEngine; // Fixed
//
//    @Value("${app.mail.from}")
//    private String fromEmail;
//
//    public void sendEmail(User user) throws Exception {
//        Context context = new Context();
//        context.setVariable("user", user); // Matches [[${user.fullName}]] in HTML
//
//        String html = templateEngine.process("email/email-template", context);
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setFrom(fromEmail); // Fixed
//        helper.setTo(user.getEmail());
//        helper.setSubject("Registration Success");
//        helper.setText(html, true);
//
//        mailSender.send(message);
//    }
//}



import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.example.emailregistration.model.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private TemplateEngine templateEngine;
	@Value("${app.mail.from}")
	private String fromEmail;
	@Value("${app.mail.from-name}")
	private String fromName;

	public void sendRegistrationEmail(com.example.emailregistration.model.User user) throws MessagingException, UnsupportedEncodingException {
		// Step 1: Build Thymeleaf context with template variables
		Context ctx = new Context();
		ctx.setVariable("user", user);
		ctx.setVariable("registeredOn", new Date());
		// Step 2: Render template → HTML string
		String htmlContent = templateEngine.process("registration-email", ctx);
		// Step 3: Create MIME email message
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		helper.setFrom(fromEmail, fromName);
		helper.setTo(user.getEmail());
		helper.setSubject("Registration Successful — Welcome!");
		helper.setText(htmlContent, true); // true = HTML content
		// Step 4: Send the email
		mailSender.send(mimeMessage);
	}

	public void sendEmail(User user) {
		// TODO Auto-generated method stub
		
	}
}