package no.noroff.property.property.property_image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PropertyImageRepository extends JpaRepository<PropertyImage, Integer> {
}
