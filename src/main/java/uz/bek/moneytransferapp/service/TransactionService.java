package uz.bek.moneytransferapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.bek.moneytransferapp.entity.Card;
import uz.bek.moneytransferapp.entity.Income;
import uz.bek.moneytransferapp.entity.Outcome;
import uz.bek.moneytransferapp.entity.Transaction;
import uz.bek.moneytransferapp.repository.CardRepository;
import uz.bek.moneytransferapp.repository.IncomeRepository;
import uz.bek.moneytransferapp.repository.OutcomeRepository;
import uz.bek.moneytransferapp.repository.TransactionRepository;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class TransactionService {
    @Autowired
    private OutcomeRepository outcomeRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void transferMoney(String sourceCardNumber, String destinationCardNumber, BigDecimal amount) {


        Card sourceCard = cardRepository.findByCardNumber(sourceCardNumber);
        Card destinationCard = cardRepository.findByCardNumber(destinationCardNumber);

        if (sourceCard == null || destinationCard == null) {
            throw new IllegalArgumentException("Karta raqami topilmadi.");
        }

        if (sourceCard.getBalance() < 0) {
            throw new IllegalArgumentException("Balansda mablag' yetarli emas.");
        }

        // Balansni to'ldirish
        sourceCard.setBalance(sourceCard.getBalance());
        destinationCard.setBalance(destinationCard.getBalance());

        // O'tkazmalarni saqlash
        Outcome outcome = new Outcome(destinationCardNumber, amount, new Date());
        Income income = new Income(sourceCardNumber, amount, new Date());

        outcomeRepository.save(outcome);
        incomeRepository.save(income);
    }
}
