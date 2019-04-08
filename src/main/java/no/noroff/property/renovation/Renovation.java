package no.noroff.property.renovation;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "renovation")
public class Renovation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int renovation_id;
    private String description;
    private LocalDateTime date_from;
    private LocalDateTime date_to;
    private int property_id;

}
