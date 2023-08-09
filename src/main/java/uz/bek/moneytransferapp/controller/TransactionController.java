package uz.bek.moneytransferapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.bek.moneytransferapp.service.TransactionService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestParam String sourceCardNumber,
                                                @RequestParam String destinationCardNumber,
                                                @RequestParam BigDecimal amount) {
        transactionService.transferMoney(sourceCardNumber, destinationCardNumber, amount);
        return ResponseEntity.ok("Money transferred successfully");
    }
}
