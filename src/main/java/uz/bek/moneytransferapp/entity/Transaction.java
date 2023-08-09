package uz.bek.moneytransferapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private LocalDateTime transactionDateTime;
    private BigDecimal amount;
    private boolean incoming;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Transaction(Card card, BigDecimal amount, boolean incoming) {
        this();
        this.card = card;
        this.amount = amount;
        this.incoming = incoming;
    }
}
