package ml.vitekbatek.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
    @Id
    @SequenceGenerator(name = "transactionsIdSeq", sequenceName = "transactions_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionsIdSeq")
    @Column(name = "id")
    @Getter
    //@Setter
    private int id;

    @Column(name = "idclient")
    @Getter
    @Setter
    private String idclient;

    @Column(name = "idlimservice")
    @Getter
    @Setter
    private String idlimservice;

    @Column(name = "reqdate")
    @Getter
    @Setter
    private Timestamp reqdate;

    @Column(name = "reqstate")
    @Getter
    @Setter
    private boolean reqstate;

    @Column(name = "emailstate")
    @Getter
    @Setter
    private boolean emailstate;

}
