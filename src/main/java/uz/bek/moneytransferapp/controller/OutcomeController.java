package uz.bek.moneytransferapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.moneytransferapp.entity.Income;
import uz.bek.moneytransferapp.entity.Outcome;
import uz.bek.moneytransferapp.service.IncomeService;
import uz.bek.moneytransferapp.service.OutcomeService;

import java.util.List;

@RestController
@RequestMapping("/api/outcome")
public class OutcomeController {

    @Autowired
    OutcomeService outcomeService;

    @GetMapping
    public ResponseEntity<List<Outcome>> getOutcomes(){
        List<Outcome> outcomes = outcomeService.getOutcomes();
        return ResponseEntity.ok(outcomes);
    }
}
