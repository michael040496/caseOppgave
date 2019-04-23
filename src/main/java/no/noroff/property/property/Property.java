package no.noroff.property.property;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.owner.ownership_log.OwnershipLog;
import no.noroff.property.property.property_image.PropertyImage;
import no.noroff.property.property.property_status.PropertyStatus;
import no.noroff.property.property.property_type.PropertyType;
import no.noroff.property.renovation.Renovation;
import no.noroff.property.valuation.Valuation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "property")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private String zip;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "built_at")
    private String built_at;

    @Column(name = "area")
    private int area;

    @Column(name = "floor")
    private int floor;

    @Column(name = "rooms")
    private int rooms;


    @ManyToOne()
    @JoinColumn(name="status_id", nullable=false)
    private PropertyStatus propertyStatus;

    @ManyToOne()
    @JoinColumn(name="property_type_id", nullable=false)
    private PropertyType propertyType;

    @OneToMany
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    private List<Renovation> renovations;

    @OneToMany
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    private List<PropertyImage> propertyImages;

    @OneToMany
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    private List<Valuation> valuations;

    @OneToMany
    @JoinColumn(name = "property_id", referencedColumnName = "property_id")
    private List<OwnershipLog> ownershipLogs;

    public Property() {

    }
}
