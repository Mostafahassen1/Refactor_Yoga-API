package Refactor_Yoga.Refactor_Yoga.controller;


import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.config.JwtService;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/clients")
public class ClientRegister {

    private ClientService clientService ;
    private JwtService jwtService ;

    private AuthenticationManager authenticationManager ;

    public ClientRegister(ClientService clientService, JwtService jwtService) {
        this.clientService = clientService;
        this.jwtService = jwtService;
    }

    //APIResponse<Client>
    @PostMapping("/register")
    public APIResponse<String> Save(@RequestBody Client object){


        clientService.save(object) ;
        String token = jwtService.generateToken(object) ;


        return APIResponse.ok(token) ;

    }

    @PostMapping("/login")
    public APIResponse<String> authentication (@RequestBody  Client client) {
        String token = clientService.authentication(client) ;

        return APIResponse.ok(token) ;

    }





}
