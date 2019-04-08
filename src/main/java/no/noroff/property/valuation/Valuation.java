package no.noroff.property.valuation;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "valuation")
public class Valuation {


    public String getComments(){return comments;}

    public void setComments(String comments){this.comments = comments;}


    public int getValue() {return value;}

    public void setValue(int value) {
        this.value = value;
    }


    public LocalDateTime getValuation_date() {return valuation_date;}

    public void setValuation_date(LocalDateTime valuation_date){this.valuation_date = valuation_date;}


    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getProperty_id() {
        return property_id;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int valuation_id;


    @Column(name="comments")
    private String comments;

    @Column(name="value")
    private int value;

    @Column(name="valuation_date")
    private LocalDateTime valuation_date;

    @Column(name="property_id")
    private int property_id;
}
