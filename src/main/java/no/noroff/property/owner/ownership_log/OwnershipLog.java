package no.noroff.property.owner.ownership_log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.owner.PropertyOwner;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "ownership_log")
public class OwnershipLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ownership_log_id")
    private int ownership_log_id;

    @Column(name="date_aquired")
    private LocalDateTime date_aquired;

    @Column(name="date_sold")
    private LocalDateTime date_sold;

    @Column(name="created_at")
    private LocalDateTime created_at;

    /*@ManyToOne()
    @JoinColumn(name="owner_id", nullable=false)
    private PropertyOwner propertyOwner;*/

    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public OwnershipLog(){

    }
}
