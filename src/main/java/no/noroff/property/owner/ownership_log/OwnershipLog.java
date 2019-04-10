package no.noroff.property.owner.ownership_log;

import lombok.Data;
import no.noroff.property.owner.PropertyOwner;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ownership_log")
public class OwnershipLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int ownership_log_id;

    @Column
    private LocalDateTime date_acquired;

    @Column
    private LocalDateTime date_sold;

    @Column
    private LocalDateTime created_at;

    @ManyToOne()
    @JoinColumn(name="owner_id", nullable=false)
    private PropertyOwner propertyOwner;

    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public OwnershipLog(){

    }
}
