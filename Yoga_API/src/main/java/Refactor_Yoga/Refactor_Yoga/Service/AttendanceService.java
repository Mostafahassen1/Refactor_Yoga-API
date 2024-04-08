package Refactor_Yoga.Refactor_Yoga.Service;


import Refactor_Yoga.Refactor_Yoga.DTO.AttendanceDTO;
import Refactor_Yoga.Refactor_Yoga.DTO.ClientDTO;
import Refactor_Yoga.Refactor_Yoga.entity.Attendance;
import Refactor_Yoga.Refactor_Yoga.util.UserClassCompositeKey;
import Refactor_Yoga.Refactor_Yoga.entitymapper.AttendanceMapper;
import Refactor_Yoga.Refactor_Yoga.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AttendanceService implements BaseService<AttendanceDTO , AttendanceService> {


    private  Attendance attendance ;
    private AttendanceMapper attendanceMapper ;
    private AttendanceRepository attendanceRepository ;



    public AttendanceService(AttendanceMapper attendanceMapper, AttendanceRepository attendanceRepository) {
        this.attendanceMapper = attendanceMapper;
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public AttendanceDTO getById(String id) {

        UUID uuid = UUID.fromString(id);
         attendance = attendanceRepository.getById(uuid) ;
        return attendanceMapper.ATTENDANCE_TO_DTO(attendance) ;
    }

    @Override
    public List<AttendanceDTO> getAll() {

        List<Attendance> attendanceList = attendanceRepository.findAll();
        return attendanceList.stream()
                .map(attendanceMapper :: ATTENDANCE_TO_DTO)
                .collect(Collectors.toList());
    }


    public void delete(String id_client  , String id_session) {

        UUID uuid_client = UUID.fromString(id_client) ;
        UUID uuid_session = UUID.fromString(id_session) ;
        UserClassCompositeKey compositeKey = new UserClassCompositeKey(uuid_client , uuid_session);
        if( attendanceRepository.existsById(uuid_client)
            && attendanceRepository.existsById(uuid_session))
            attendanceRepository.deleteById(compositeKey);
        else
            throw new NoSuchElementException();

    }

    @Override
    public void save(AttendanceDTO object) {

        attendance = attendanceMapper.DTO_TO_ATTENDANCE(object) ;
        attendanceRepository.save(attendance) ;

    }
}
