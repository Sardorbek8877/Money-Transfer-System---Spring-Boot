package uz.bek.moneytransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.moneytransferapp.entity.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
