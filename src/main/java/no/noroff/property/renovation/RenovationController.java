package no.noroff.property.renovation;

import no.noroff.property.account.Account;
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
public class RenovationController {

    @Autowired
    private RenovationRepository renovationRepository;

    @GetMapping("/renovation")
    public ResponseEntity<List<Renovation>> getAll(){
        try{
           List<Renovation> renovation = renovationRepository.findAll();
            return new ResponseEntity<>(renovation, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/renovation")
    public ResponseEntity<Renovation> addRenovation(@RequestBody Renovation renovation){
        try{
            renovationRepository.save(renovation);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
