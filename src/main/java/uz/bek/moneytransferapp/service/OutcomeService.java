package uz.bek.moneytransferapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bek.moneytransferapp.entity.Income;
import uz.bek.moneytransferapp.entity.Outcome;
import uz.bek.moneytransferapp.repository.IncomeRepository;
import uz.bek.moneytransferapp.repository.OutcomeRepository;

import java.util.List;

@Service
public class OutcomeService {

    @Autowired
    OutcomeRepository outcomeRepository;

    public List<Outcome> getOutcomes(){
        return outcomeRepository.findAll();
    }
}
