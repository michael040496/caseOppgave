package no.noroff.property.owner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.account.account_type.AccountType;
import no.noroff.property.owner.owner_type.OwnerType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "owner")
public class PropertyOwner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="date_of_birt")
    private LocalDateTime date_of_birth;

    @Column(name="d_number")
    private int d_number;

    @Column(name="created_at")
    private LocalDateTime created_at;

    @Column(name="owner_type_id")
    private int owner_type_id;

    @ManyToOne
    @JoinTable(
            name="owner_type",
            joinColumns=@JoinColumn(name="owner_type_id"))
    private OwnerType ownerType;

    public PropertyOwner(){

    }

}
