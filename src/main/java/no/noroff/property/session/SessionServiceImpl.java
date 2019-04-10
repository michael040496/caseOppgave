package no.noroff.property.session;

import no.noroff.property.account.Account;
import no.noroff.property.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SessionServiceImpl implements SessionService{
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getSessionById(int id) {
        return sessionRepository.getOne(id);
    }

}
