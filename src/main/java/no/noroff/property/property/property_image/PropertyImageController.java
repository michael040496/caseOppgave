package no.noroff.property.property.property_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PropertyImageController {

    @Autowired
    private PropertyImageService propertyImageService;


}
