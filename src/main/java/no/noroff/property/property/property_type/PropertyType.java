package no.noroff.property.property.property_type;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "property_type")
public class PropertyType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int property_type_id;
    private String name;
}
