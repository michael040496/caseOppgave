package no.noroff.property.account;

import no.noroff.property.account.account_type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if(account == null) throw new UsernameNotFoundException(email);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return null;

    }



}
