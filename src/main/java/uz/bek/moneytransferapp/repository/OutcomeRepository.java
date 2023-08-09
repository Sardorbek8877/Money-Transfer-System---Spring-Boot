package uz.bek.moneytransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.moneytransferapp.entity.Outcome;

public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {

}
