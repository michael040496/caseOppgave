package no.noroff.property.account;

import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountSerivce {
    List<Account> findAll();
    Account createAccount(Account account);
}
