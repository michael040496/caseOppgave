package no.noroff.property.property.property_status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PropertyStatusRepository extends JpaRepository<PropertyStatus, Integer> {
}
