
package Refactor_Yoga.Refactor_Yoga.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table( name = "session")
public class Session {
    public Session() {
    }

    public Session(List<Attendance> attendanceList, String title, String description, int capacity, int duration) {
        this.attendanceList = attendanceList;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.duration = duration;
    }

    @OneToMany(mappedBy = "session")
     private List<Attendance> attendanceList ;

    @Id
    @GeneratedValue (strategy =  GenerationType.UUID)
    private UUID id ;


    @Column( nullable = false , length =  70 )
    private String  title ;

    @Column(length =  150 )
    private String description ;

    @Column( nullable = false)
    private  int capacity ;

    @Column( nullable = false)
    private int duration ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }
}




