package no.noroff.property.account;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.account.account_type.AccountType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "surname")
    private String surname;


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

    @ManyToOne()
    @JoinColumn(name="account_type_id", nullable=false, insertable = false, updatable = false)
    private AccountType accountType;


    public Account(){

    }
}