package no.noroff.property.valuation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ValuationRepository extends JpaRepository<Valuation, Integer> {

}
