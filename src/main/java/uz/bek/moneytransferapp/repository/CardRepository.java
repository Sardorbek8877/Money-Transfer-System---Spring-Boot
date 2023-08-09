package uz.bek.moneytransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.moneytransferapp.entity.Card;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    boolean existsCardByUsername(String username);

    boolean existsByNumber(String cardNumber);

    Card findByCardNumber(String cardNumber);
}
