package no.noroff.property.property;
import lombok.Data;
import no.noroff.property.property.property_status.PropertyStatus;
import no.noroff.property.property.property_type.PropertyType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "property")
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private int property_id;

    @Column(name = "property_name")
    private String property_name;

    @Column(name = "value")
    private int value;

    @Column(name = "line_1")
    private String line_1;

    @Column(name = "line_2")
    private String line_2;

    @Column(name = "municipality")
    private String municipality;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private int zip;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name="status_id", nullable=false)
    private PropertyStatus propertyStatus;

    @ManyToOne()
    @JoinColumn(name="property_type_id", nullable=false)
    private PropertyType propertyType;


    public Property() {

    }
}
