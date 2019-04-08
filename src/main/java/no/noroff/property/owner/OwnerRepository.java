package no.noroff.property.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.acl.Owner;

@Repository
interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
