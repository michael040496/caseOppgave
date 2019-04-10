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
    private int renovation_id;

    @Column(name="description")
    private String description;

    @Column(name="date_form")
    private LocalDateTime date_from;

    @Column(name="date_to")
    private LocalDateTime date_to;

    @Column(name="property_id")
    private int property_id;

    @ManyToOne
    @JoinTable(name = "property",
            joinColumns = {@JoinColumn(name = "property_id")},
            inverseJoinColumns = {@JoinColumn(name =  "property.property_id")})
    private Property property;

    public Renovation(){

    }

}
