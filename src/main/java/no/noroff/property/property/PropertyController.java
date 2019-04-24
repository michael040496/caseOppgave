package no.noroff.property.property;

import no.noroff.property.account.Account;
import no.noroff.property.renovation.Renovation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        try {
            List<Map<String, Object>> properties = new LinkedList<>();
            for(Property property : propertyService.findAll()){
                Map<String, Object> prop = new HashMap<>();
                prop.put("images", property.getPropertyImages());
                prop.put("property_name", property.getProperty_name());
                prop.put("propertyType", property.getPropertyType());
                prop.put("latitude", property.getLatitude());
                prop.put("longitude", property.getLongitude());
                prop.put("floor", property.getFloor());
                prop.put("rooms", property.getRooms());;
                properties.add(prop);
            }
            return new ResponseEntity<>(properties, HttpStatus.OK);
            //List<Property> property = propertyService.findAll();

        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/properties/{property_id}")
    public ResponseEntity<Property> loadOne(@PathVariable int property_id){
        try{
            Property property = propertyService.getPropertyById(property_id);
            return new ResponseEntity<>(property, HttpStatus.ACCEPTED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/properties")
    public ResponseEntity<Property> addProperty(@RequestBody Property property){
        try{
            propertyService.createProperty(property);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/properties/update")
    public ResponseEntity<Property> update(@RequestBody Property property){
        try{

            Property p = propertyService.update(property.getProperty_id(), property);
            System.out.println(p);
            return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/propertyBuyer")
    public ResponseEntity<List<Property>> propertyBuyer() {
        try {
            List<Property> property = propertyService.findAll();
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/propertyAgent")
    public ResponseEntity<List<Property>> propertyAgent() {
        try {
            List<Property> property = propertyService.findAll();
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
