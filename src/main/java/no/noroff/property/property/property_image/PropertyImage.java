package no.noroff.property.property.property_image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.property.Property;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "property_image")
public class PropertyImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_image_id")
    private int property_image_id;

    @Column(name = "url")
    private String url;

    @ManyToOne()
    @JoinColumn(name="property_id", nullable=false)
    private Property property;

    public PropertyImage(){

    }


}
