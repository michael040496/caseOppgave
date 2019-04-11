package no.noroff.property.property;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.property.property_image.PropertyImage;
import no.noroff.property.property.property_status.PropertyStatus;
import no.noroff.property.property.property_type.PropertyType;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
    private int zip;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @ManyToOne()
    @JoinColumn(name="status_id", nullable=false)
    private PropertyStatus propertyStatus;

    @ManyToOne()
    @JoinColumn(name="property_type_id", nullable=false)
    private PropertyType propertyType;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private Set<PropertyImage> propertyImages;




    public Property() {

    }
}
