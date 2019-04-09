package no.noroff.property.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Integer> {
}
