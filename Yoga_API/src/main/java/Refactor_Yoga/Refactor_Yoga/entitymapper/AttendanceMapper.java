package Refactor_Yoga.Refactor_Yoga.entitymapper;

import Refactor_Yoga.Refactor_Yoga.DTO.AttendanceDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {


    /*
        ClientDTO  ClientToClientDTO( Client client) ;

    Client  ClientDTOToClient( ClientDTO clientDTO ) ;
     */

    @Mapping(source = "session.id", target = "sessionId")
    @Mapping(source = "client.id" , target = "clientId")
    AttendanceDTO ATTENDANCE_TO_DTO( Attendance attendance);


    @Mapping(source = "sessionId", target = "session.id")
    @Mapping(source = "clientId" , target = "client.id")
    Attendance DTO_TO_ATTENDANCE (AttendanceDTO  attendanceDTO) ;

}
