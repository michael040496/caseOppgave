package no.noroff.property.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PropertyRepository extends JpaRepository<Property, Integer> {

}
