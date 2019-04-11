package no.noroff.property.property.property_image;

import no.noroff.property.property.Property;

public interface PropertyImageService {
    PropertyImage createPropertyImage(PropertyImage propertyImage);
    PropertyImage getPropertyImageById(int property_image_id);
}
