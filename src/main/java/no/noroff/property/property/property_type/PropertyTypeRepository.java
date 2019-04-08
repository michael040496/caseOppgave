package no.noroff.property.property.property_type;

import com.sun.xml.internal.ws.developer.JAXWSProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PropertyTypeRepository extends JpaRepository<PropertyType, Integer> {
}
