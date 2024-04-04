package Refactor_Yoga.Refactor_Yoga.DTO;

import java.util.UUID;

public record ClientDTO(
        UUID id ,
        String firstName,
        String lastName,
        String phone,
        String email,
        String nationality
) {

}