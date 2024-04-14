
package Refactor_Yoga.Refactor_Yoga.entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table( name = "instructor")
public class Instructor {

    public Instructor() {
    }

    public Instructor(String password ,String firstName, String lastName, String phone, String email, int salary) {
        this.firstName = firstName;
        this.password = password ;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }


    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id ;


    @Column( name= "first_name" , nullable = false , length = 30)
    private String firstName ;

    @Column( name ="last_name" , nullable = false , length = 30)
    private String lastName ;

    @Column( nullable = false , unique = true )
    private String phone ;
    @Column( nullable = false , unique = true )
    private String email ;

    @Column( name= "password" , nullable = false )
    private String password ;

    @Column(nullable = false)
    private int salary ;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}






