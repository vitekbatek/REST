package ml.vitekbatek.rest.schedular;

import ml.vitekbatek.rest.JDBC.Transactions;
import ml.vitekbatek.rest.Email.SendEmail;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
@EnableScheduling
public class ScheduleEvent {

    @Scheduled (fixedDelay = 600000)
    public void sendEmails() throws Exception {
        Transactions transactions = new Transactions();
        ResultSet resultSet;
        resultSet = transactions.getRecords(  "SELECT * \n" +
                                                    "FROM transactions \n" +
                                                    "INNER JOIN clients \n" +
                                                    "ON transactions.idclient = clients.id  \n" +
                                                    "INNER JOIN limservices \n" +
                                                    "ON transactions.idclient = limservices.id \n" +
                                                    "WHERE emailstate = false");
        SendEmail sendEmail = new SendEmail();
        try {
            while (resultSet.next()) {

                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String email = resultSet.getString("email");
                boolean reqstate = resultSet.getBoolean("reqstate");
                boolean emailstate = resultSet.getBoolean("emailstate");

                System.out.print("Name: " + name);
                System.out.print(" Service: " + description);
                System.out.print(" Email: " + email);
                System.out.print(" Status = " + reqstate);
                System.out.print(" Email send = " + emailstate);
                System.out.println();

                sendEmail.sendEmails(email, name, description);
            }
        }catch(Exception ex) {
                System.err.println("Error in sending email: "+ex);
        }
    }
}
