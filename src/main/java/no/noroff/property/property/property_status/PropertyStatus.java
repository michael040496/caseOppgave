package no.noroff.property.property.property_status;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "property_status")
public class PropertyStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_status_id")
    private int property_status_id;

    @Column(name = "property_status_name")
    private String property_status_name;

    public PropertyStatus(){

    }
}
