package ml.vitekbatek.rest.Email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;




public class SendEmail{


    private JavaMailSender emailSender = new JavaMailSenderImpl();

    public boolean sendEmail(String emailclient, String nameclient, String clientservice, boolean reqstate){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("smartservice@vitekbatek.ml");
        message.setTo(emailclient);
        message.setSubject("Smartservice");
        if (reqstate) {
            message.setText("Hello, " + nameclient + "! The service " + clientservice+ " is approved for you :)" );
        } else {
            message.setText("Hello, " + nameclient + "! The service " + clientservice+ " is not approved for you :(");
        }


        try {
            emailSender.send(message);
            //System.out.println("Email for " + nameclient + " Sent!");
            return true;
        }catch(Exception ex) {
            //System.err.println("Error in sending email: "+ex);
            return false;
        }
    }
}