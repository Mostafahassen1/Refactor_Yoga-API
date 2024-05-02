
package Refactor_Yoga.Refactor_Yoga.entity;

import Refactor_Yoga.Refactor_Yoga.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
//client
@Table( name ="mempers")
public class Client  {


    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private  List<Payment> paymentList ;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Attendance> attendanceList ;

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id ;


    @Column( name= "first_name" , nullable = false , length = 50  )
    private String firstName ;

    @Column( name = "password"    )
    private String password ;

    @Column( name= "last_name" , nullable = false , length = 50)
    private String lastName ;

    @Column( unique = true , nullable = false)
   private String phone ;

    @Column ( unique = true , nullable = false )
   private String email ;

   private String nationality ;


    @Column(name ="Role")
    @Enumerated(EnumType.STRING)
    private Role role;



    public Client( Role role , String firstName, String password , String lastName, String phone, String email, String nationality) {

        this.firstName = firstName;
        this.password = password ;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.nationality = nationality;
        this.role = role ;
    }

    public Client() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }


}


