package no.noroff.property.account.account_type;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_type_id;

    @Column(name = "account_type_name")
    private String name;

}
