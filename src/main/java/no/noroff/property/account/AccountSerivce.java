package no.noroff.property.account;

import java.util.List;
import java.util.Optional;

public interface AccountSerivce {
    List<Account> findAll();
    Account create(Account object);
    Account update(long id, Account object);
    Account getById(long id);
    Optional<Account> getByUsernameOrEmail(String username, String email);

}
