package no.noroff.property.valuation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "valuation")
public class Valuation {

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
