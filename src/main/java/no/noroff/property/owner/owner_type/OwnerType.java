package no.noroff.property.owner.owner_type;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "owner_type")
public class OwnerType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_type_id;
    private String name;
}
