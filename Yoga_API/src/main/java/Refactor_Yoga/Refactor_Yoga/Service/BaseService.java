package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;

import java.util.List;


public interface BaseService<DTO , entity> {

    DTO getById( String id) ;
    List<DTO> getAll() ;


    void save(entity object) ;

}
