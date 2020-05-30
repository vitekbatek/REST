package ml.vitekbatek.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "limservices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Limservice {
    @Id
    @SequenceGenerator(name = "limservicesIdSeq", sequenceName = "limservices_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "limservicesIdSeq")
    @Column(name = "id")
    @Getter
    @Setter
    private int id;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "comment")
    @Getter
    @Setter
    private String comment;

    @Column(name = "lim")
    @Getter
    @Setter
    private int lim;


}
