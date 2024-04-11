package Refactor_Yoga.Refactor_Yoga.controller;


import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService ;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public APIResponse<ClientDTO> getClientById(@PathVariable String  id){
        ClientDTO client = clientService.getById(id) ;
        return  APIResponse.ok(client) ;
    }

    @GetMapping("/")
    public APIResponse<List<ClientDTO> >getAllClients(){
        List<ClientDTO>  clients = clientService.getAll() ;
        if( clients.isEmpty() )
            return  APIResponse.notFound();
        else
        return APIResponse.ok(clients) ;

    }

    @PostMapping("/")
    public APIResponse<Client> Save(@RequestBody Client object){
        
            clientService.save(object) ;

        return APIResponse.ok(object) ;

    }

    @DeleteMapping("/{id}")
    public APIResponse<ClientDTO> deleteClient( @PathVariable String  id){
        clientService.delete(id);
        return  APIResponse.deleted();

    }
}
