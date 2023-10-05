package com.prueba.adapter;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void enviarCorreo(String correo, String msge)  {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("admin@example.com", "Example.com Admin"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("user@example.com", "Mr. User"));
			msg.setSubject("Solicitud");
			msg.setText(msge);
			Transport.send(msg);
		} catch (UnsupportedEncodingException | MessagingException e) {
		}
	}

}
