package no.noroff.property.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

//@RolesAllowed({"ROLE_BUYER", "ROLE_AGENT"})
//@CrossOrigin(origins = "*")
@RolesAllowed({"ROLE_BUYER", "ROLE_AGENT"})
@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountSerivce accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ObjectMapper objectMapper;


    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAll() {
        try {

            List<Account> acc = accountService.findAll();


            return new ResponseEntity<>(acc, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/account/test")
    public ResponseEntity<Optional<Account>> getByUsernameEmail(String username, String email) {
        try {

            Optional<Account> acc = accountService.getByUsernameOrEmail(username, "ok@gmail.com");


            return new ResponseEntity<>(acc, HttpStatus.OK);
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
