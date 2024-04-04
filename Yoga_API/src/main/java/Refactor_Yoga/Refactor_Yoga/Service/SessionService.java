package Refactor_Yoga.Refactor_Yoga.Service;

import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.InstructorDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.SessionDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Client;
import Refactor_Yoga.Refactor_Yoga.entity.Session;
import Refactor_Yoga.Refactor_Yoga.entitymapper.SessionMapper;
import Refactor_Yoga.Refactor_Yoga.repository.InstructorRepository;
import Refactor_Yoga.Refactor_Yoga.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SessionService implements BaseService<SessionDTO , Session>{

    private  Session session ;
    private SessionRepository sessionRepository ;
    private SessionMapper sessionMapper ;

    public SessionService() {
    }

    public SessionService(SessionRepository sessionRepository, SessionMapper sessionMapper) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
    }

    @Override
    public SessionDTO getById(String id) {

        UUID uuid = UUID.fromString(id) ;
         session = sessionRepository.getById(uuid) ;
        return sessionMapper.SessionTOSessionDTO(session) ;
    }

    @Override
    public List<SessionDTO> getAll() {

        List<Session> sessionList = sessionRepository.findAll() ;

        return sessionList.stream()
                .map( sessionMapper :: SessionTOSessionDTO)
                .collect(Collectors.toList());
    }


    public void delete(String id) {
        UUID uuid = UUID.fromString(id) ;
        sessionRepository.deleteById(uuid);

    }

    @Override
    public void save(SessionDTO object) {

         session = sessionMapper.SessionDTOToSession(object) ;
        sessionRepository.save(session) ;
    }
}
