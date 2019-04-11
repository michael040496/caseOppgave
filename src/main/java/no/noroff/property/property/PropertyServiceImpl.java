package no.noroff.property.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public Property getPropertyById(int property_id) {
        return propertyRepository.getOne(property_id);
    }

    @Override
    public Property update(int id, Property property) {
        property.setProperty_id(id);
        return propertyRepository.save(property);
    }
}
