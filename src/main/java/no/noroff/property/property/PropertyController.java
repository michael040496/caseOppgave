package no.noroff.property.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAll() {
        try {
            List<Property> property = propertyService.findAll();
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity<Property> loadOne(@PathVariable int id){
        try{
            Property property = propertyService.getPropertyById(id);
            return new ResponseEntity<>(property, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
