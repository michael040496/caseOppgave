package no.noroff.property.owner;

import java.util.List;

public interface PropertyOwnerService {
    List<PropertyOwner> findAll();
    PropertyOwner createOwner(PropertyOwner propertyOwner);
}
