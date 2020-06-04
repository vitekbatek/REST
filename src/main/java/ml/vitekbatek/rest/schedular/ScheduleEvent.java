package ml.vitekbatek.rest.schedular;

import com.sun.rowset.CachedRowSetImpl;
import ml.vitekbatek.rest.JDBC.Transactions;
import ml.vitekbatek.rest.Email.SendEmail;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.sql.rowset.CachedRowSet;

@Component
@EnableScheduling
public class ScheduleEvent {

    @Scheduled (fixedDelay = 60000)
    public void sendEmails() throws Exception {

        Transactions transactions = new Transactions();

        CachedRowSetImpl cachedRowSet = transactions.getNotSendEmailRecords();
        SendEmail sendEmail = new SendEmail();
        if (cachedRowSet.size()>0) {
            try {
                while (cachedRowSet.next()) {
                    int id = cachedRowSet.getInt("id");
                    String name = cachedRowSet.getString("name");
                    String description = cachedRowSet.getString("description");
                    String email = cachedRowSet.getString("email");
                    boolean reqstate = cachedRowSet.getBoolean("reqstate");

                    if (sendEmail.sendEmail(email, name, description, reqstate)) {
                        transactions.setSendEmailRecords(id);
                    }
                    ;
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
    }
}
