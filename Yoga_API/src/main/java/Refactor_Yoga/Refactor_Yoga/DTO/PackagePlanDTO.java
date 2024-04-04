package Refactor_Yoga.Refactor_Yoga.DTO;

import java.util.UUID;

public record PackagePlanDTO(
        UUID id ,
        String name ,
        int price ,
        int numberOfClasses
){

}

