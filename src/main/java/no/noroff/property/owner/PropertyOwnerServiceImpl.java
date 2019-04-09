package no.noroff.property.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyOwnerServiceImpl implements PropertyOwnerService {
    @Autowired
    private PropertyOwnerRepository propertyOwnerRepository;

    @Override
    public PropertyOwner createOwner(PropertyOwner propertyOwner) {
        return propertyOwnerRepository.save(propertyOwner);
    }

    @Override
    public List<PropertyOwner> findAll() {
        return propertyOwnerRepository.findAll();
    }


}
