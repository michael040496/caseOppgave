package no.noroff.property.owner.ownership_log;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OwnershipLogController {
    @Autowired
    private OwnershipLogService ownershipLogService;

    @GetMapping("/ownershiplog")
    public ResponseEntity<List<OwnershipLog>> getAll(){
        try{
            List<OwnershipLog> ownershipLogs = ownershipLogService.findAll();
            return new ResponseEntity<>(ownershipLogs, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/ownershiplog")
    public ResponseEntity<OwnershipLog> addOwnershiplog(@RequestBody OwnershipLog ownershipLog){
        try{
            ownershipLogService.createOwnershipLog(ownershipLog);
            return new ResponseEntity<>(ownershipLog, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
