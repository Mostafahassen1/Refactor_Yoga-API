package Refactor_Yoga.Refactor_Yoga.entitymapper;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface ClientMapper {

    ClientDTO  ClientToClientDTO( Client client) ;

    Client  ClientDTOToClient( ClientDTO clientDTO ) ;


}
