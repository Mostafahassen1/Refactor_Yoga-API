package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.PackagePlanDTO;
import Refactor_Yoga.Refactor_Yoga.entity.PackagePlan;
import Refactor_Yoga.Refactor_Yoga.entitymapper.PackagePlanMapper;
import Refactor_Yoga.Refactor_Yoga.repository.PakagePlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PackagePlanService implements  BaseService<PackagePlanDTO , PackagePlan>{

    private  PackagePlan packagePlan ;
    private PackagePlanMapper packagePlanMapper ;
    private PakagePlanRepository  packagePlanRepository ;



    public PackagePlanService(PackagePlanMapper packagePlanMapper, PakagePlanRepository pakagePlanRepository) {
        this.packagePlanMapper = packagePlanMapper;
        this.packagePlanRepository = pakagePlanRepository;
    }

    @Override
    public PackagePlanDTO getById(String id) {
         UUID uuid = UUID.fromString(id) ;
          packagePlan = packagePlanRepository.getById(uuid) ;
         return packagePlanMapper.PACKAGE_PLAN_TO_DTO(packagePlan) ;
    }

    @Override
    public List<PackagePlanDTO> getAll() {

        List<PackagePlan> packagePlanList = packagePlanRepository.findAll();
        return packagePlanList.stream()
                .map(packagePlanMapper :: PACKAGE_PLAN_TO_DTO)
                .collect(Collectors.toList());
    }


    public void delete(String id) {
        UUID uuid = UUID.fromString(id) ;
        if( packagePlanRepository.existsById(uuid))
            packagePlanRepository.deleteById(uuid);
        else
            throw new NoSuchElementException() ;
    }

    @Override
    public void save(PackagePlan object) {


        packagePlanRepository.save(packagePlan) ;


    }
}
