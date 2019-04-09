package no.noroff.property.renovation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenovationServiceImpl implements RenovationService {

    @Autowired
    private RenovationRepository renovationRepository;

    @Override
    public Renovation createRenovation(Renovation renovation) {
        return renovationRepository.save(renovation);
    }

    @Override
    public List<Renovation> findAll() {
        return renovationRepository.findAll();
    }
}
