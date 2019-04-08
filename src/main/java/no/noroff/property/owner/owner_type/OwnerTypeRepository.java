package no.noroff.property.owner.owner_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OwnerTypeRepository extends JpaRepository<OwnerType, Integer> {
}
