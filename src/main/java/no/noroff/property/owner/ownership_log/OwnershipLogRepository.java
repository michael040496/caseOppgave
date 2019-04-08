package no.noroff.property.owner.ownership_log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OwnershipLogRepository extends JpaRepository<OwnershipLog, Integer> {
}
