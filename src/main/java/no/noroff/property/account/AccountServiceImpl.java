package no.noroff.property.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
        return accountRepository.save(object);
    }

    @Override
    public Account getById(int id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account update(int id, Account object) {
        object.setId(id);
        return accountRepository.save(object);
    }
}
