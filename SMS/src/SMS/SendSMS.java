package SMS;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendSMS {

	private String phoneNumber;
	private String carrier;
	private String recipient;
	
	private String password;
	private String username;
	private String sender;
    private String host = "smtp.gmail.com";
    
	//Constructor
	public SendSMS(String phoneNumber, String carrier){

		//use these as defaults for now, but can be reset using 
		//setPassword and setUser
		this.sender = "valleydeoroll@gmail.com";
		this.password = "eng100D!";
		this.username = "valleydeoroll@gmail.com";
		
		//Set the information
		this.phoneNumber = phoneNumber;
		this.carrier = carrier;
		
		switch(carrier){
			case "att":
				recipient = this.phoneNumber + "@txt.att.net";
				System.out.println(recipient);
			break;
			case "sprint":
				recipient = this.phoneNumber + "@messaging.sprintpcs.com";
			break;
			case "tmobile":
				recipient = this.phoneNumber + "@tmomail.net";
			break;
			case "verizon":
				recipient = this.phoneNumber + "@vtext.com";
			break;
			case "boost":
				recipient = this.phoneNumber + "@myboostmobile.com";
			break;
			case "cellular south":
				recipient = this.phoneNumber + "@csouth1.com";
			break;
			case "centennial wireless":
				recipient = this.phoneNumber + "@cwemail.com";
			break;

		}		
	}
	
	//Set the password that is used to send from
	public void setPassword(String password){
		this.password = password;
	}
	
	
	//set the 
	public void setUsername(String username){
		this.username = username;
	}
	
	public void sendMessage(String textToSend, String subject){
		
		  //Set everything up
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");
	      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });
		
		
	      try {
	          // Create a default MimeMessage object.
	          Message message = new MimeMessage(session);

	          // Set From: header field of the header.
	          message.setFrom(new InternetAddress(sender));

	          // Set To: header field of the header.
	          message.setRecipients(Message.RecipientType.TO,
	          InternetAddress.parse(recipient));
	          
	          // Set Subject: header field
	          //message.setSubject(subject);
	          
	          // Now set the actual message
	          message.setText(textToSend);
	          
	          // Send message
	          Transport.send(message);

	          //Print to the console if the message was sent successfully
	          System.out.println("Sent message successfully....");
	          
	      //catch exception if there is a problem
	      } catch (MessagingException e) {
	    	  throw new RuntimeException(e);
	      }
	      
	      
	      
	}
	
	
	
	
	
}