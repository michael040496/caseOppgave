package no.noroff.property.account.account_type;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "account_type")
public class AccountType {
    @Id
    @Column(name = "account_type_id")
    private int accountTypeId;


    @Column(name = "account_type_name")
    private String name;

    public AccountType(){

    }
}
