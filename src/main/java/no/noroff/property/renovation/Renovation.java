package no.noroff.property.renovation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "renovation")
public class Renovation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renovation_id")
    private int renovation_id;

    @Column(name="description")
    private String description;

    @Column(name="date_from")
    private LocalDateTime date_from;

    @Column(name="date_to")
    private LocalDateTime date_to;

    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;


    public Renovation(){

    }

}
