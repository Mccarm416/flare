package flare.model.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailer {
	
	private JavaMailSender mailSender;
	
	@Autowired
	public Mailer(JavaMailSender mailSender) {
		
		this.mailSender = mailSender;
	}
	
	
	public void registerMail(String address, String token) throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(address);
		mail.setFrom("flarestudentwebservice@gmail.com");
		mail.setSubject("Welcome to Flare! - Registration Token");
		mail.setText("Your registration token is " + token );
		
		mailSender.send(mail);
	}
	
public void ticketMail(String subject, String message) throws MailException {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("flarestudentwebservice@gmail.com");
		mail.setFrom("flarestudentwebservice@gmail.com");
		mail.setSubject(subject);
		mail.setText(message);
		
		mailSender.send(mail);
	}


	public JavaMailSender getMailSender() {
		return mailSender;
	}


	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	
}
