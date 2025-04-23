package cm.polytechnique.Mail;

import cm.polytechnique.Notification.Notification;
import jakarta.mail.Session;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class TestEmail {
    
    public static void testEmail(String receiverEmail,  String otpCode) {
        final String senderEmail = "todoapp20511@gmail.com";
        final String appPassword = "12345"; // pas ton mot de passe Gmail habituel
        final String recipientEmail = receiverEmail;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication("todoapp20511@gmail.com", "atclakxfeikxdbvr");
            }
        });
        

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Test d'envoi de mail depuis Java");
            message.setText("Salut a vous, votre code est " + otpCode + ". Utilisez le pour accéder à votre compte!");
            Transport.send(message);
            System.out.println("Email envoyé avec succès !");
        } catch (MessagingException e) {
            Notification.showError("ERROR","","You'r Offline");
            e.printStackTrace();
        }
    }
}
