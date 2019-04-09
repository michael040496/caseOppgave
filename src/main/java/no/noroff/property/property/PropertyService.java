package no.noroff.property.property;

import java.util.List;

public interface PropertyService {
    List<Property> findAll();
    Property createProperty(Property property);
    Property getPropertyById(int id);

}
