package no.noroff.property.renovation;

import no.noroff.property.valuation.Valuation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RenovationRepository extends JpaRepository<Renovation, Integer> {
}
