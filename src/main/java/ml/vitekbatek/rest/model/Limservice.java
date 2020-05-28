package ml.vitekbatek.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "limservices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Limservice {
    @Id
    @SequenceGenerator(name = "limservicesIdSeq", sequenceName = "limservices_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "limservicesIdSeq")
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "lim")
    private int lim;


    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCount() {
        return lim;
    }

    public void setCount(int count) {
        this.lim = count;
    }
}
