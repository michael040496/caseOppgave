package no.noroff.property.valuation;

import no.noroff.property.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValuationController {

    
    private final ValuationService valuationService;

    @Autowired
    public ValuationController(ValuationService valuationService){
        this.valuationService = valuationService;
    }

    @RequestMapping("/valuation")
    public ResponseEntity<List<Valuation>> getAll(){
        try{
          List<Valuation> valuation = valuationService.findAll();
          return new ResponseEntity<>(valuation, HttpStatus.OK);
        }
        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/valuation")
    public ResponseEntity<Valuation> addValuation(@RequestBody Valuation valuation){
        try{
          valuationService.createValuation(valuation);
          return new ResponseEntity<>(valuation, HttpStatus.OK);
        }

        catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
