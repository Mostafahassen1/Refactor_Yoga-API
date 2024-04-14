package Refactor_Yoga.Refactor_Yoga.repository;

import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor , UUID> {
    Instructor findByEmail(String email);
}


