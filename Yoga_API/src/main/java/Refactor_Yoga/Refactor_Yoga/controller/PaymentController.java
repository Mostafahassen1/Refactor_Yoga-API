package Refactor_Yoga.Refactor_Yoga.controller;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.PaymentDTO;
import Refactor_Yoga.Refactor_Yoga.Service.ClientService;
import Refactor_Yoga.Refactor_Yoga.Service.PaymentService;
import Refactor_Yoga.Refactor_Yoga.util.APIResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private PaymentService paymentService ;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{id}")
    public APIResponse<PaymentDTO> getClientById(@PathVariable String  id){
        PaymentDTO paymentDTO = paymentService.getById(id) ;
        return  APIResponse.ok(paymentDTO) ;
    }

    @GetMapping("/")
    public APIResponse<List<PaymentDTO>>getAllClients(){
        List<PaymentDTO>  paymentDTOList = paymentService.getAll() ;
        if( paymentDTOList.isEmpty() )
            return  APIResponse.notFound();
        else
            return APIResponse.ok(paymentDTOList) ;

    }

    @PostMapping("/")
    public APIResponse<PaymentDTO> Save( @RequestBody PaymentDTO object){

        paymentService.save(object) ;

        return APIResponse.ok(object) ;

    }

    @DeleteMapping("/{id}")
    public APIResponse<ClientDTO> deleteClient( @PathVariable String  id){
        paymentService.delete(id);
        return  APIResponse.deleted();

    }
}
