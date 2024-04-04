
package Refactor_Yoga.Refactor_Yoga.repository;

import Refactor_Yoga.Refactor_Yoga.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance , UUID> {
}


