package no.noroff.property.property.property_image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyImageServiceImpl implements PropertyImageService {

    @Autowired
    private PropertyImageRepository propertyImageRepository;


    @Override
    public PropertyImage createPropertyImage(PropertyImage propertyImage) {return propertyImageRepository.save(propertyImage);}

    @Override
    public PropertyImage getPropertyImageById(int property_image_id) {return propertyImageRepository.getOne(property_image_id);}
}
