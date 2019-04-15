package no.noroff.property.account;

import no.noroff.property.account.account_type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountSerivce{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account object) {
        object.setPassword(bCryptPasswordEncoder.encode(object.getPassword()));
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


    @Override
    @Transactional(readOnly = true)
    public Account loadUserByEmail(String email){
        Account account = accountRepository.findByEmail(email);
        if(account == null) {
            throw new UsernameNotFoundException(email);
        }
        System.out.println("Found user " + account);


        return null;

    }



}
