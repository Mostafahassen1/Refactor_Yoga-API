package Refactor_Yoga.Refactor_Yoga.DTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record AttendanceDTO(
        UUID clientId,
        UUID sessionId ,
        LocalDateTime attendanceDate
){

}
