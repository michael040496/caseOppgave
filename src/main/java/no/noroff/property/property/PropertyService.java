package no.noroff.property.property;

import no.noroff.property.account.Account;

import java.util.List;

public interface PropertyService {
    List<Property> findAll();
    Property createProperty(Property property);
    Property getPropertyById(int property_id);
    Property update(int id, Property property);


}
