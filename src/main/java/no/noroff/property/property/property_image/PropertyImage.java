package no.noroff.property.property.property_image;

import lombok.Data;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "property_image")
public class PropertyImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_image_id")
    private int property_image_id;

    @Column(name = "url")
    private String url;

    @Column(name = "property_id")
    private int property_id;

    @ManyToOne
    @JoinTable(name = "property",
            joinColumns = {@JoinColumn(name = "property_id")},
            inverseJoinColumns = {@JoinColumn(name =  "property.property_id")})
    private Property property;

}
