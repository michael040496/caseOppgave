package no.noroff.property.owner.ownership_log;

import lombok.Data;
import no.noroff.property.owner.PropertyOwner;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Owner;
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

    @Column
    private int owner_id;

    @Column
    private int property_id;

    @ManyToOne
    @JoinTable(
            name="owner",
            joinColumns=@JoinColumn(name="owner_id"))
    private PropertyOwner propertyOwner;

    @ManyToOne
    @JoinTable(
            name="property",
            joinColumns=@JoinColumn(name="property_id"))
    private Property property;

    public OwnershipLog(){

    }
}
