package no.noroff.property.owner.ownership_log;


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
public class OwnershipLogController {
    @Autowired
    private OwnershipLogRepository ownershipLogRepository;

    @GetMapping("/ownershiplog")
    public ResponseEntity<List<OwnershipLog>> getAll(){
        try{
            List<OwnershipLog> ownershipLogs = ownershipLogRepository.findAll();
            return new ResponseEntity<>(ownershipLogs, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/ownershiplog")
    public ResponseEntity<OwnershipLog> addOwnershiplog(@RequestBody OwnershipLog ownershipLog){
        try{
            ownershipLogRepository.save(ownershipLog);
            return new ResponseEntity<>(ownershipLog, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
