package no.noroff.property.owner;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "owner")
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private LocalDateTime date_of_birth;
    private int d_number;
    private LocalDateTime created_at;

}
