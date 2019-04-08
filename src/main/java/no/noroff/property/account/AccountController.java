package no.noroff.property.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAll() {
        try {
            List<Account> account = accountRepository.findAll();
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/account")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account){
        try{
            accountRepository.save(account);
            return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
