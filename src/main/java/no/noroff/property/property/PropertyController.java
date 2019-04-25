package no.noroff.property.property;

import no.noroff.property.account.Account;
import no.noroff.property.renovation.Renovation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAll() {
        try {
            List<Property> properties = propertyService.findAll();
            /*for(Property property : propertyService.findAll()){
                Map<String, Object> prop = new HashMap<>();
                prop.put("images", property.getPropertyImages());
                prop.put("property_name", property.getProperty_name());
                prop.put("propertyType", property.getPropertyType());
                prop.put("latitude", property.getLatitude());
                prop.put("longitude", property.getLongitude());
                prop.put("floor", property.getFloor());
                prop.put("rooms", property.getRooms());;
                prop.put("property_id", property.getProperty_id());
                properties.add(prop);
            }*/
            return new ResponseEntity<>(properties, HttpStatus.OK);
            //List<Property> property = propertyService.findAll();

        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //fetch for guest
    @GetMapping("/properties/{property_id}")
    public ResponseEntity<?> loadOne(@PathVariable int property_id){
        try{
            Property property = propertyService.getPropertyById(property_id);
            Map<String, Object> prop = new HashMap<>();
            prop.put("images", property.getPropertyImages());
            prop.put("property_name", property.getProperty_name());
            prop.put("propertyType", property.getPropertyType());
            prop.put("latitude", property.getLatitude());
            prop.put("longitude", property.getLongitude());
            prop.put("line_1", property.getLine_1());
            prop.put("property_id", property.getProperty_id());
            return new ResponseEntity<>(prop, HttpStatus.ACCEPTED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //fetch for ROLE BUYER
    //@GetMapping("/propertybuyer/{property_id}")
  //  @RolesAllowed({"ROLE_BUYER"})
    @GetMapping("/propertybuyer/{property_id}")
    public ResponseEntity<?> propertyBuyer(@PathVariable int property_id) {
        try {
            Property property = propertyService.getPropertyById(property_id);
            Map<String, Object> prop = new HashMap<>();
            prop.put("images", property.getPropertyImages());
            prop.put("property_name", property.getProperty_name());
            prop.put("propertyType", property.getPropertyType());
            prop.put("latitude", property.getLatitude());
            prop.put("longitude", property.getLongitude());
            prop.put("floor", property.getFloor());
            prop.put("rooms", property.getRooms());;
            prop.put("city", property.getCity());
            prop.put("zip", property.getZip());
            prop.put("area", property.getArea());
            prop.put("build_at", property.getBuilt_at());
            prop.put("renovations", property.getRenovations());


            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // fetch for role agent
   // @GetMapping("/propertyagent/{property_id}")
  //  @RolesAllowed({"ROLE_AGENT"})
    @GetMapping("/propertyagent/{property_id}")
    public ResponseEntity<?> propertyAgent(@PathVariable int property_id) {
        try {
            Property property = propertyService.getPropertyById(property_id);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (DataAccessException e) {
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



}
