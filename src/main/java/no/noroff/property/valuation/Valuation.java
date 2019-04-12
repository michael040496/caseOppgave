package no.noroff.property.valuation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "valuation")
public class Valuation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "valuation_id")
    private int valuation_id;

    @Column(name="valuation_comments")
    private String valuation_comments;

    @Column(name="value")
    private int value;

    @Column(name="valuation_date")
    private LocalDateTime valuation_date;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public Valuation(){

    }
}
