
package Refactor_Yoga.Refactor_Yoga.repository;

import Refactor_Yoga.Refactor_Yoga.entity.PackagePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PakagePlanRepository extends JpaRepository<PackagePlan, UUID> {
}


