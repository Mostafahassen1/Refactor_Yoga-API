package Refactor_Yoga.Refactor_Yoga.entitymapper;

import Refactor_Yoga.Refactor_Yoga.DTO.SessionDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Session;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface SessionMapper {


    SessionDTO SessionTOSessionDTO(Session session) ;
    Session SessionDTOToSession(SessionDTO sessionDTO) ;
}
