
package Refactor_Yoga.Refactor_Yoga.entity;

import Refactor_Yoga.Refactor_Yoga.util.UserClassCompositeKey;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name =" attend")
public class Attendance {

    @EmbeddedId
    UserClassCompositeKey id ;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name ="client_id")
    private Client client ;


    @ManyToOne
    @MapsId("sessionId")
    @JoinColumn(name="session_id")
    private Session session ;



    @Column( name = "attendance_date" , nullable = false )
    private LocalDateTime attendanceDate ;

    public Attendance(Client client, Session session, LocalDateTime attendanceDate) {
        this.client = client;
        this.session = session;
        this.attendanceDate = attendanceDate;
    }

    public Attendance() {
    }

    public UserClassCompositeKey getId() {
        return id;
    }

    public void setId(UserClassCompositeKey id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LocalDateTime getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDateTime attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}






