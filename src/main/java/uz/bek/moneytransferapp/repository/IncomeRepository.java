package uz.bek.moneytransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.moneytransferapp.entity.Card;
import uz.bek.moneytransferapp.entity.Income;

import java.util.UUID;

public interface IncomeRepository extends JpaRepository<Income, UUID> {

}
