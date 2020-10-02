/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail;

/**
 *
 * @author kp
 */

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SimpleSendEmail {
 
    private static String femail = "bpe9397@gmail.com";
    private static String pass = "Avinash@321";
    boolean done = false;

    public SimpleSendEmail() {

    }
    
    public boolean send(String toemail, String Subject, String message) {
        String to = toemail;
        String subject = Subject;
        String messageText = message;
        boolean sessionDebug = false;
// Create some properties and get the default Session.
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port",  ""+587);
        props.setProperty("mail.smtp.starttls.enable", "true");

        Session session = createSmtpSession();
// Set debug on the Session so we can see what is going on
// Passing false will not echo debug info, and passing true
// will.        
        session.setDebug(sessionDebug);
        try {
// Instantiate a new MimeMessage and fill it with the
// required information.
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(femail));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);
// Hand the message to the default transport service
// for delivery.
            Transport.send(msg);
            done = true;
            System.out.println("Email successfully send!!!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            done = false;
            System.out.println("Email does not send!!!");
        }
        return done;
    }

    public static Session createSmtpSession() {
        final Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "" + 587);
        props.setProperty("mail.smtp.starttls.enable", "true");
        // props.setProperty("mail.debug", "true");

        return Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(femail, pass);
            }
        });
    }
    
    public static void main(String args[]) {
    	SimpleSendEmail email = new SimpleSendEmail();
    	email.send("avinasht801@gmail.com", "Hello Avi;", "Test Email");
    	
    }
   
}