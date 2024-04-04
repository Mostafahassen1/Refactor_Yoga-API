
package Refactor_Yoga.Refactor_Yoga.repository;

import Refactor_Yoga.Refactor_Yoga.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment , UUID> {
}




