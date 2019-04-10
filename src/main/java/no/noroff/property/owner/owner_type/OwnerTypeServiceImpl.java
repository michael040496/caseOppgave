package no.noroff.property.owner.owner_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerTypeServiceImpl implements OwnerTypeService {

    @Autowired
    private OwnerTypeRepository ownerTypeRepository;

    @Override
    public OwnerType createOwnerType(OwnerType ownerType) {
        return ownerTypeRepository.save(ownerType);
    }

    @Override
    public List<OwnerType> findAll() {
        return ownerTypeRepository.findAll();
    }
}
