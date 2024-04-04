package Refactor_Yoga.Refactor_Yoga.entitymapper;

import Refactor_Yoga.Refactor_Yoga.DTO.AttendanceDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.PaymentDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Attendance;
import Refactor_Yoga.Refactor_Yoga.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(source = "packagePlan.id", target = "packageId")
    @Mapping(source = "client.id" , target = "ClientId")
    PaymentDTO PAYMENT_TO_DTO(Payment payment);


    @Mapping(source = "packageId", target = "packagePlan.id" )
    @Mapping(source = "ClientId" , target = "client.id")
    Payment DTO_TO_PAYMENT (PaymentDTO  paymentDTO ) ;
}
