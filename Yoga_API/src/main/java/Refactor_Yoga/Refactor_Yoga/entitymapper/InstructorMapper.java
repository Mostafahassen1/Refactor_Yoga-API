package Refactor_Yoga.Refactor_Yoga.entitymapper;

import Refactor_Yoga.Refactor_Yoga.DTO.InstructorDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface InstructorMapper {


    InstructorDTO INSTRUCTOR_TO_DTO (Instructor instructor) ;
    Instructor DTO_TO_INSTRUCTOR(InstructorDTO instructorDTO) ;
}
