package Refactor_Yoga.Refactor_Yoga.controller;


import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/clients")
public class ClientControllerV2 {

    private ClientService clientService ;


    public ClientControllerV2 (ClientService clientService) {
        this.clientService = clientService;
    }



    @PostMapping("/register")
    public APIResponse<Client> Save(@RequestBody Client object){

        clientService.save(object) ;

        return APIResponse.ok(object) ;

    }


}
