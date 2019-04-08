package no.noroff.property.valuation;

import java.util.List;

public interface ValuationService {
    List<Valuation> findAll();
    Valuation createValuation(Valuation valuation);
}
