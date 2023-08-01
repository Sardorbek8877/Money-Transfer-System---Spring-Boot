package uz.bek.moneytransferapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bek.moneytransferapp.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
