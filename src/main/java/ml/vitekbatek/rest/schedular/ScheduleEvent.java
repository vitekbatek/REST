package ml.vitekbatek.rest.schedular;

import ml.vitekbatek.rest.JDBC.Transactions;
import ml.vitekbatek.rest.Email.SendEmail;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
@EnableScheduling
public class ScheduleEvent {

    @Scheduled (fixedDelay = 60000)
    public void sendEmails() throws Exception {

        Transactions transactions = new Transactions();

        ResultSet resultSet = transactions.getNotSendEmailRecords();
        SendEmail sendEmail = new SendEmail();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String email = resultSet.getString("email");
                boolean reqstate = resultSet.getBoolean("reqstate");

                if (sendEmail.sendEmail(email, name, description, reqstate)){
                    transactions.setSendEmailRecords(id);
                };
            }
        }catch(Exception ex) {
                System.err.println("Error in sending email: "+ex);
        }
    }
}
