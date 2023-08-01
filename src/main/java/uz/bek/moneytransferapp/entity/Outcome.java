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

    private BigDecimal commision_amount;

    private Date date;

    private UUID from_card_id;

    private UUID to_card_id;

    @ManyToOne
    private Card card;
}
