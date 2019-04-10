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
/*
    @GetMapping("/properties/{ID}")
    public ResponseEntity<Property> getPropertyById(@PathVariable int id) {
        try {
            List<Property> propertyList = propertyService.findAll();
            System.out.println("Trying to find character: " + id);

            Property returnProperty = null;
            for (Property p : propertyList) {
                if (p.getProperty_id() == (id)) {
                    System.out.println(" --- PROPERTY FOUND --- ");

                    returnProperty = p;
                }
            }
            if (returnProperty == null) {
                System.out.println(" --- PROPERTY WAS NOT FOUND --- ");
            }
            return new ResponseEntity<>(returnProperty, HttpStatus.OK);
        } catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    */

}
