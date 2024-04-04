package Refactor_Yoga.Refactor_Yoga.Service;


import Refactor_Yoga.Refactor_Yoga.DTO.InstructorDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Instructor;
import Refactor_Yoga.Refactor_Yoga.entitymapper.InstructorMapper;
import Refactor_Yoga.Refactor_Yoga.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InstructorService implements BaseService<InstructorDTO , InstructorRepository> {

    private  Instructor  instructor ;
    private InstructorRepository instructorRepository ;
    private InstructorMapper instructorMapper ;

    public InstructorService() {
    }

    public InstructorService(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public InstructorDTO getById(String id) {
        UUID uuid = UUID.fromString(id) ;
          instructor = instructorRepository.getById(uuid) ;
          return instructorMapper.INSTRUCTOR_TO_DTO(instructor) ;


    }

    @Override
    public List<InstructorDTO> getAll() {

        List<Instructor> instructorList = instructorRepository.findAll();
        return instructorList.stream()
                .map( instructorMapper :: INSTRUCTOR_TO_DTO)
                .collect(Collectors.toList());
    }


    public void delete(String id) {

        UUID uuid = UUID.fromString(id) ;
        if(instructorRepository.existsById(uuid))
            instructorRepository.deleteById(uuid);
        else
            throw new NoSuchElementException() ;

    }

    @Override
    public void save(InstructorDTO object) {

        instructor = instructorMapper.DTO_TO_INSTRUCTOR(object) ;
        instructorRepository.save(instructor) ;
    }
}
