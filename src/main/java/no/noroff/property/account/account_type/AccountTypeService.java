package no.noroff.property.account.account_type;

import no.noroff.property.owner.PropertyOwner;

import java.util.List;

public interface AccountTypeService {
    List<AccountType> findAll();
    AccountType createAccountType(AccountType accountType);
}
