package no.noroff.property.session;

import no.noroff.property.account.Account;
import no.noroff.property.owner.owner_type.OwnerType;

import java.util.List;

public interface SessionService {
    List<Session> findAll();
    Session createSession(Session session);
    Session getSessionById(int id);

}
