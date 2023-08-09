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
public class Income {

    @Id
    @GeneratedValue
    private UUID id;

    private BigDecimal amount;

    private Date date;

    private String sourceCardNumber;

    public Income(String sourceCardNumber,  BigDecimal amount, Date date) {
        this.amount = amount;
        this.date = date;
        this.sourceCardNumber = sourceCardNumber;
    }
}
