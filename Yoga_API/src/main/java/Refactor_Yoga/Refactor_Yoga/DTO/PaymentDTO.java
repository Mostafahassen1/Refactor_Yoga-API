package Refactor_Yoga.Refactor_Yoga.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentDTO (
       // UUID id ,
        UUID ClientId ,
        UUID packageId ,
        LocalDateTime paymentDate
){

}

