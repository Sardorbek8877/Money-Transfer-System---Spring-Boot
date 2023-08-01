package uz.bek.moneytransferapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private String username;

    private String number;

    private double balance;

    private boolean active;

    private UUID userId;
}
