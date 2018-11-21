package com.omertasci.javamail;

import java.util.Properties;

import javax.mail.Session;

/*
 * Notice that I am using Session.getInstance() to get the Session object
 *  by passing the Properties object. We need to set the mail.smtp.host 
 *  property with the SMTP server host. If the SMTP server is not running
 *   on default port (25), then you will also need to set mail.smtp.port 
 *   property. Just run this program with your no-authentication SMTP 
 *   server and by setting recipient email id as your own email id and 
 *   you will get the email in no time.

The program is simple to understand and works well, but in real life most
 of the SMTP servers use some sort of authentication such as TLS or SSL 
 authentication. So we will now see how to create Session object for 
 these authentication protocols.
 * */

public class SimpleEmail {
	
	public static void main(String[] args) {
		
	    System.out.println("SimpleEmail Start");
		
	    String smtpHostServer = "smtp.gmail.com" ;//"smtp.example.com";
	    String emailID = "omertasci.ce@gmail.com";//"email_me@example.com";
	    
	    Properties props = System.getProperties();

	    props.put("mail.smtp.host", smtpHostServer);

	    Session session = Session.getInstance(props, null);
	    
	    EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
	}

}

