package Refactor_Yoga.Refactor_Yoga.DTO;

import java.util.UUID;

public record InstructorDTO (
        UUID id ,
        String firstName ,
        String lastName ,
        String  phone ,
        String email ,
        int salary
){

}
