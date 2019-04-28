package no.noroff.property.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService propertyOwnerService;

    @GetMapping("/owner")
    public ResponseEntity<List<PropertyOwner>> getAll(){
        try{
           List<PropertyOwner> propertyOwner = propertyOwnerService.findAll();
           return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }



    @PostMapping("/owner")
    public ResponseEntity<PropertyOwner> addOwner(@RequestBody PropertyOwner propertyOwner) {
        try{

            propertyOwnerService.createOwner(propertyOwner);
            return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
