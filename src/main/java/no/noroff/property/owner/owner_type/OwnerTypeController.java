package no.noroff.property.owner.owner_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OwnerTypeController {

    @Autowired
    private OwnerTypeService ownerTypeService;

    @GetMapping("/ownertype")
    public ResponseEntity<List<OwnerType>> getAll(){
        try{
            List<OwnerType> ownerTypes = ownerTypeService.findAll();
            return new ResponseEntity<>(ownerTypes, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/ownertype")
    public ResponseEntity<OwnerType> addOwnerType(@RequestBody OwnerType ownerType){
        try{
            ownerTypeService.createOwnerType(ownerType);
            return new ResponseEntity<>(ownerType, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
