package no.noroff.property.owner.owner_type;

import java.util.List;

public interface OwnerTypeService {
    List<OwnerType> findAll();
    OwnerType createOwnerType(OwnerType ownerType);
}
