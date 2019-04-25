package no.noroff.property.account;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.account.account_type.AccountType;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@DynamicUpdate
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "surname")
    private String surname;


    @Column(name = "username")
    private String username;

    @Column(name = "account_name")
    private String name;


    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();


    @Column(name = "account_type_id")
    private int accountTypeId;

    //nullable=false, insertable = false, updatable = false
    @ManyToOne()
    @JoinColumn(name="account_type_id", nullable=false, insertable = false, updatable = false)
    private AccountType accountType;



   /*
    @OneToMany()
    @JoinColumn(name="account_type_id", nullable=false, insertable = false, updatable = false)
    private Set<AccountType> accountType = new HashSet<>();
*/

    public Account(){

    }

   public Account(String username,String surname, String name, String phone, String email, LocalDate dateOfBirth, String password, int accountTypeId) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.username = username;
        this.accountTypeId = accountTypeId;

    }
}