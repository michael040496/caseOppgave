package no.noroff.property.account.account_type;

import no.noroff.property.owner.PropertyOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RolesAllowed("ROLE_BUYER")
@RestController
@CrossOrigin(origins = "*")
public class AccountTypeController {
    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping("/accounttype")
    public ResponseEntity<List<AccountType>> getAll(){
        try{
            List<AccountType> accountType = accountTypeService.findAll();
            return new ResponseEntity<>(accountType, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/accounttype")
    public ResponseEntity<AccountType> addAccountType(@RequestBody AccountType accountType) {
        try{
            accountTypeService.createAccountType(accountType);
            return new ResponseEntity<>(accountType, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
