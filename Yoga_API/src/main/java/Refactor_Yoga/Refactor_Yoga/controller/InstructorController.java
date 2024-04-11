package Refactor_Yoga.Refactor_Yoga.controller;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.InstructorDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.Service.InstructorService;
import Refactor_Yoga.Refactor_Yoga.entity.Instructor;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private InstructorService instructorService ;


    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/{id}")
    public APIResponse<InstructorDTO> getClientById(@PathVariable String  id){
        InstructorDTO instructor = instructorService.getById(id) ;
        return  APIResponse.ok(instructor) ;
    }

    @GetMapping("/")
    public APIResponse<List<InstructorDTO>>getAllClients(){
        List<InstructorDTO>  instructorDTOList = instructorService.getAll() ;
        if( instructorDTOList.isEmpty() )
            return  APIResponse.notFound();
        else
            return APIResponse.ok(instructorDTOList) ;

    }

    @PostMapping("/")
    public APIResponse<Instructor> Save( @RequestBody Instructor object){

        instructorService.save(object) ;

        return APIResponse.ok(object) ;

    }

    @DeleteMapping("/{id}")
    public APIResponse<InstructorDTO> deleteClient( @PathVariable String  id){
        instructorService.delete(id);
        return  APIResponse.deleted();

    }
}
