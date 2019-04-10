package no.noroff.property.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import no.noroff.property.account.Account;
import no.noroff.property.account.account_type.AccountType;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Table(name = "session")
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int session_id;

    @Column(name = "token")
    private String token;

    @OneToOne()
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Session() {}

}
