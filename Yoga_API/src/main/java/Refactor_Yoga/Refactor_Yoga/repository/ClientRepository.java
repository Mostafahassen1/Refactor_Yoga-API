package Refactor_Yoga.Refactor_Yoga.repository;

import Refactor_Yoga.Refactor_Yoga.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
