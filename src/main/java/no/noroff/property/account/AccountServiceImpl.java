package no.noroff.property.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Service
public class AccountServiceImpl implements AccountSerivce{


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
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


    @Transactional(readOnly = true)
    @Override
    public Account loadUserByEmail(String email) throws UsernameNotFoundException{
        Account account = accountRepository.findByEmail(email);
        if(account == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        System.out.println("Found user " + account);
        return account;

    }


}
