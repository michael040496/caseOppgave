package no.noroff.property.account.account_type;

import no.noroff.property.owner.PropertyOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountTypeController {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @GetMapping("/accounttype")
    public ResponseEntity<List<AccountType>> getAll(){
        try{
            List<AccountType> accountType = accountTypeRepository.findAll();
            return new ResponseEntity<>(accountType, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/accounttype")
    public ResponseEntity<AccountType> addAccountType(@RequestBody AccountType accountType) {
        try{
            accountTypeRepository.save(accountType);
            return new ResponseEntity<>(accountType, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
