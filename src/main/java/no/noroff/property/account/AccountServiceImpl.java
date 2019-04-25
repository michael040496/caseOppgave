package no.noroff.property.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountSerivce{


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<Account> getByUsernameOrEmail(String username, String email) {
        return accountRepository.findByUsernameOrEmail(username, email);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getbyEmailOrUsername(String email, String username) {
        return accountRepository.findByEmailOrUsername(username, email);
    }

    @Override
    public Account save(Account acc) {
        return accountRepository.save(acc);
    }

    @Override
    public Account create(Account object) {
       // object.setPassword(bCryptPasswordEncoder.encode(object.getPassword()));
        return accountRepository.save(object);
    }

    @Override
    public Account getById(long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account update(long id, Account object) {
        object.setId(id);
        return accountRepository.save(object);
    }



}
