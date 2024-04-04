package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.PackagePlanDTO;
import Refactor_Yoga.Refactor_Yoga.entity.PackagePlan;
import Refactor_Yoga.Refactor_Yoga.entitymapper.PackagePlanMapper;
import Refactor_Yoga.Refactor_Yoga.repository.PakagePlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PackagePlanService implements  BaseService<PackagePlanDTO , PackagePlan>{

    private PackagePlanMapper packagePlanMapper ;
    private PakagePlanRepository  pakagePlanRepository ;

    public PackagePlanService() {
    }

    public PackagePlanService(PackagePlanMapper packagePlanMapper, PakagePlanRepository pakagePlanRepository) {
        this.packagePlanMapper = packagePlanMapper;
        this.pakagePlanRepository = pakagePlanRepository;
    }

    @Override
    public PackagePlanDTO getById(String id) {
         UUID uuid = UUID.fromString(id) ;
         PackagePlan packagePlan = pakagePlanRepository.getById(uuid) ;
         return packagePlanMapper.PACKAGE_PLAN_TO_DTO(packagePlan) ;
    }

    @Override
    public List<PackagePlanDTO> getAll() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void save(PackagePlanDTO object) {

    }
}
