package no.noroff.property.owner.ownership_log;
import java.util.List;

public interface OwnershipLogService {
    List<OwnershipLog> findAll();
    OwnershipLog createOwnershipLog(OwnershipLog ownershipLog);
}
