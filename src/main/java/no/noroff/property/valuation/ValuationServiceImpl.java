package no.noroff.property.valuation;

import no.noroff.property.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValuationServiceImpl implements ValuationService {

    @Autowired
    private final ValuationRepository valuationRepository;

    @Autowired
    public ValuationServiceImpl(ValuationRepository valuationRepository){
        this.valuationRepository = valuationRepository;
    }

    @Override
    public List<Valuation> findAll(){
        return valuationRepository.findAll();
    }

    @Override
    public Valuation createValuation(Valuation valuation){
        return valuationRepository.save(valuation);
    }

}
