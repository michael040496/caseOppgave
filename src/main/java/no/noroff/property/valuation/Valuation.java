package no.noroff.property.valuation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.property.Property;

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

    @Column(name="valuation_comments")
    private String valuation_comments;

    @Column(name="valuation")
    private int valueation;

    @Column(name="valuation_date")
    private LocalDateTime valuation_date;

    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public Valuation(){

    }
}
