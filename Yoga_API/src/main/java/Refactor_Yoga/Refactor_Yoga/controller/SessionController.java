package Refactor_Yoga.Refactor_Yoga.controller;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.SessionDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.Service.SessionService;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    private SessionService sessionService ;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{id}")
    public APIResponse<SessionDTO> getClientById(@PathVariable String  id){
        SessionDTO session = sessionService.getById(id) ;
        return  APIResponse.ok(session) ;
    }

    @GetMapping("/")
    public APIResponse<List<SessionDTO>>getAllClients(){
        List<SessionDTO>  sessions = sessionService.getAll() ;
        if( sessions.isEmpty() )
            return  APIResponse.notFound();
        else
            return APIResponse.ok(sessions) ;

    }

    @PostMapping("/")
    public APIResponse<SessionDTO> Save( @RequestBody SessionDTO object){

        sessionService.save(object) ;

        return APIResponse.ok(object) ;

    }

    @DeleteMapping("/{id}")
    public APIResponse<SessionDTO> deleteClient( @PathVariable String  id){
        sessionService.delete(id);
        return  APIResponse.deleted();

    }
}
