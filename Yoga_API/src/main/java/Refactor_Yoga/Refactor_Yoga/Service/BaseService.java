package Refactor_Yoga.Refactor_Yoga.Service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface BaseService<DTO , entity> {

    DTO getById( String id) ;
    List<DTO> getAll() ;




    void save(DTO object) ;

}
