package no.noroff.property.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {
    @Autowired
    private SessionService sessionService;


    @GetMapping("/session")
    public ResponseEntity<List<Session>> getAll() {
        try {
            List<Session> sessions = sessionService.findAll();
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/session")
    public ResponseEntity<Session> create(@RequestBody Session session){
        try{
            sessionService.createSession(session);

            return new ResponseEntity<>(session, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/session/{session_id}")
    public ResponseEntity<Session> loadOne(@PathVariable int session_id){
        try{
            Session session = sessionService.getSessionById(session_id);
            return new ResponseEntity<>(session, HttpStatus.ACCEPTED);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
