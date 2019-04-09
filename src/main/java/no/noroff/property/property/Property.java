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

    @Column(name = "status_id")
    private int status_id;

    @Column(name = "property_type_id")
    private int property_type_id;

    @ManyToOne
    @JoinTable(name = "property_status",
                joinColumns = {@JoinColumn(name = "status_id")},
                inverseJoinColumns = {@JoinColumn(name =  "status_id")})
    private PropertyStatus propertyStatus;

    @ManyToOne
    @JoinTable(name = "property_type",
                joinColumns = {@JoinColumn(name = "property_type_id")},
                inverseJoinColumns = {@JoinColumn(name = "property_type_id")})
    private PropertyType propertyType;




    public Property() {

    }
}
