package no.noroff.property.owner.owner_type;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "owner_type")
public class OwnerType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_type_id;

    @Column
    private String name;
}
