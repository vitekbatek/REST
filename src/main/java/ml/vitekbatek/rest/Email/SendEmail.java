package ml.vitekbatek.rest.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;




public class SendEmail{


    private JavaMailSender emailSender = new JavaMailSenderImpl();

    public void sendEmails(String emailclient, String nameclient, String clientservice){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("smartservice@vitekbatek.ml");
        message.setTo(emailclient);
        message.setSubject("Smartservice");
        message.setText("Hello, "+nameclient+"! You follow the next service: " + clientservice);

        try {
            emailSender.send(message);
            System.out.println("Email for " + nameclient + " Sent!");
        }catch(Exception ex) {
            System.err.println("Error in sending email: "+ex);
        }
    }
}