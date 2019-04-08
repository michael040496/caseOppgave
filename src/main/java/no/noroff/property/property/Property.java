package no.noroff.property.property;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "property")
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int property_id;
    private String name;
    private int value;
    private String line_1;
    private String line_2;
    private String municiplaity;
    private String city;
    private int zip;
    private LocalDateTime date;
    private int status_id;
    private int property_type_id;

}
