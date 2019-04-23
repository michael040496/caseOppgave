package no.noroff.property.account.account_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType createAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }


}