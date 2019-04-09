package no.noroff.property.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    @GetMapping("/owner")
    public ResponseEntity<List<PropertyOwner>> getAll(){
        try{
           List<PropertyOwner> propertyOwner = propertyOwnerRepository.findAll();
           return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/owner")
    public ResponseEntity<PropertyOwner> addOwner(PropertyOwner propertyOwner) {
        try{
            propertyOwnerRepository.save(propertyOwner);
            return new ResponseEntity<>(propertyOwner, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
