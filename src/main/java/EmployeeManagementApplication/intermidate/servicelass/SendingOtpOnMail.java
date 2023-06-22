package EmployeeManagementApplication.intermidate.servicelass;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.Transport;
@Service
public class SendingOtpOnMail {
 
//    String message = "OTP sent Successully";
//    String subject = "OTP Confirmation";
//    String from = "nagsenshinde358@gmail.com";
//    public void sendOtpEmail(String message,String subject,String from) {
//         
//    	String host = "smtp.gmail.com";
//    	Properties prop = new Properties();
//    	prop.put("smtp.gmail.com", host);
//    	prop.put("smtp.gmail.port", "465");
//    	prop.put("smtp.gmail.ssl.enable", true);
//    	prop.put("smtp.gmail.auth",true);
//    	
//    	Session session =Session.getInstance(prop,new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("nagsenshinde358@gmail.com","Nagsen@123");
//			}	
//    		
//		});
//    	
//    	session.setDebug(true);
//    	
//       }
    
//    public void sendOtpEmail(String recipientEmail, int otp1) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipientEmail);
//        message.setSubject("One-Time Password (OTP)");
//        message.setText("Your OTP is: " + otp1);
//        mailSender.send(message);
//    }
    
   public void sendOtpEmail(String recipientEmail, int otp1) {
            String from = "nagsenshinde33@gmail.com";  
            String password = "hnybgblgloipqxth";
            String subject = "One-Time Password (OTP)";
            String messageText = "Your OTP is: " + otp1;

            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            //properties.put("mail.smtp.ssl.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
            	@Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
                message.setSubject(subject);
                message.setText(messageText);

                Transport.send(message);
                System.out.println("OTP email sent successfully!");
            } catch (MessagingException e) {
                System.out.println("Failed to send OTP email: " + e.getMessage());
            }
        }
    }

        
    

	
	 
 

