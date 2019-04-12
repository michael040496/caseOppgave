package no.noroff.property.account;

import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountSerivce {
    List<Account> findAll();
    Account create(Account object);
    Account update(long id, Account object);
    Account getById(long id);
    Account loadUserByEmail(String email);

}
