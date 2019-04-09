package no.noroff.property.renovation;


import java.util.List;

public interface RenovationService {
    List<Renovation> findAll();
    Renovation createRenovation(Renovation Renovation);
}
