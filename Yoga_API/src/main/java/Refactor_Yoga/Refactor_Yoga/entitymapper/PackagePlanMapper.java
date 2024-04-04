package Refactor_Yoga.Refactor_Yoga.entitymapper;


import Refactor_Yoga.Refactor_Yoga.DTO.PackagePlanDTO;
import Refactor_Yoga.Refactor_Yoga.entity.PackagePlan;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface PackagePlanMapper {

    PackagePlanDTO PACKAGE_PLAN_TO_DTO(PackagePlan packagePlan) ;
    PackagePlan DTO_TO_PACKAGE_PLAN(PackagePlanDTO packagePlanDTO) ;
}
