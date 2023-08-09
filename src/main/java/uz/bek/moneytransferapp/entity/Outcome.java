package uz.bek.moneytransferapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Outcome {

    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal amount;

    private Date date;

    private String destinationCardNumber;

    public Outcome(String destinationCardNumber,  BigDecimal amount, Date date) {
        this.amount = amount;
        this.date = date;
        this.destinationCardNumber = destinationCardNumber;
    }
}
