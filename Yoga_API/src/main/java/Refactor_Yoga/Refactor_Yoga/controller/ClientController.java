package Refactor_Yoga.Refactor_Yoga.controller;


import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientService clientService ;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable String  id){
        ClientDTO client = clientService.getById(id) ;
        return  client ;
    }

    @GetMapping("/")
    public List<ClientDTO> getAllClients(){
        List<ClientDTO>  clients = clientService.getAll() ;
        return clients ;

    }

    @PostMapping("/")
    public void Save( @RequestBody ClientDTO object){
        clientService.save(object) ;
    }

    @DeleteMapping("/{id}")
    public void deeleteClient( @PathVariable String  id){
        clientService.delete(id);
    }
}
