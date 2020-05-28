package ml.vitekbatek.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
    @Id
    @SequenceGenerator(name = "transactionsIdSeq", sequenceName = "transactions_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionsIdSeq")
    @Column(name = "id")
    private int id;

    @Column(name = "idClient")
    private String idClient;

    @Column(name = "idLimservice")
    private String idLimservice;

    @Column(name = "reqDate")
    private Date reqDate;

    @Column(name = "reqState")
    private boolean reqState;

    @Column(name = "emailState")
    private boolean emailState;

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdLimservice() {
        return idLimservice;
    }

    public void setIdLimservice(String idLimservice) {
        this.idLimservice = idLimservice;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public boolean isReqState() {
        return reqState;
    }

    public void setReqState(boolean reqState) {
        this.reqState = reqState;
    }

    public boolean isEmailState() {
        return emailState;
    }

    public void setEmailState(boolean emailState) {
        this.emailState = emailState;
    }
}
