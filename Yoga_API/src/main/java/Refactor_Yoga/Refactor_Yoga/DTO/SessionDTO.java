package Refactor_Yoga.Refactor_Yoga.DTO;

import java.util.UUID;

public record SessionDTO (
        UUID id ,
        String title ,
        String description ,
        int capacity ,
        int duration
){

}
