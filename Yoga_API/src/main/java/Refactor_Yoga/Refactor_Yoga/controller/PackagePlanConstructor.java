package Refactor_Yoga.Refactor_Yoga.controller;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.PackagePlanDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.Service.PackagePlanService;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/packages")
public class PackagePlanConstructor {
    private PackagePlanService packagePlanService ;

    public PackagePlanConstructor(PackagePlanService packagePlanService) {
        this.packagePlanService = packagePlanService;
    }

    @GetMapping("/{id}")
    public APIResponse<PackagePlanDTO> getClientById(@PathVariable String  id){
        PackagePlanDTO packagePlanDTO = packagePlanService.getById(id) ;
        return  APIResponse.ok(packagePlanDTO) ;
    }

    @GetMapping("/")
    public APIResponse<List<PackagePlanDTO>>getAllClients(){
        List<PackagePlanDTO>  packages = packagePlanService.getAll() ;
        if( packages.isEmpty() )
            return  APIResponse.notFound();
        else
            return APIResponse.ok(packages) ;

    }

    @PostMapping("/")
    public APIResponse<PackagePlanDTO> Save( @RequestBody PackagePlanDTO object){

        packagePlanService.save(object) ;

        return APIResponse.ok(object) ;

    }

    @DeleteMapping("/{id}")
    public APIResponse<PackagePlanDTO> deleteClient( @PathVariable String  id){
        packagePlanService.delete(id);
        return  APIResponse.deleted();

    }
}
