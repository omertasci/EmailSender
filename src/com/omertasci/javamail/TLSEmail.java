package com.omertasci.javamail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	public static void main(String[] args) {
		
		Properties props = new Properties();
		ConfigLoader confLd= new ConfigLoader("docs/email-tls.properties");
		try {
			props = confLd.getPropValues();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		final String fromEmail = "abc@gmail.com"; //requires valid gmail id
//		final String password = "xyzt"; // correct password for gmail id
//		final String toEmail = "qwe@hotmail.com"; // can be any email id 
		
		final String fromEmail = props.getProperty("smtp.fromEmail"); //requires valid gmail id
		final String password = props.getProperty("smtp.password");  // correct password for gmail id
		final String toEmail = props.getProperty("smtp.toEmail");  // can be any email id 
		
		System.out.println("TLSEmail Start");
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//		props.put("mail.smtp.port", "587"); //TLS Port
//		props.put("mail.smtp.auth", "true"); //enable authentication
//		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
		
	}

	
}

