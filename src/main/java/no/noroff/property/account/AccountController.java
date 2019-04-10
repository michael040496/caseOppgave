package no.noroff.property.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountSerivce accountService;

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAll() {
        try {
            List<Account> account = accountService.findAll();
            for (Account acc : account) {
                System.out.println(acc.toString());
            }
            return new ResponseEntity<>(account, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/account/create")
    public ResponseEntity<Account> create(@RequestBody Account account){
        try{
            accountService.create(account);

            return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/account/update")
    public ResponseEntity<Account> update(@RequestBody Account account){
        try{

           Account acc = accountService.update(account.getId(), account);
            System.out.println(acc);
           return new ResponseEntity<>(acc, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> loadOne(@PathVariable int id){
        try{
            Account account = accountService.getById(id);
            System.out.println(account.toString());
            return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
