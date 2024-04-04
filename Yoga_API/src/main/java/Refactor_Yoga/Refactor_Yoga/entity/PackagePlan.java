
package Refactor_Yoga.Refactor_Yoga.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table( name = "package")
public class PackagePlan {
    public PackagePlan() {
    }

    public PackagePlan( String name, int price, int numberOfClasses) {

        this.name = name;
        this.price = price;
        this.numberOfClasses = numberOfClasses;
    }

   @OneToMany(mappedBy = "packagePlan")
   private List<Payment> paymentList ;


    @Id
    @GeneratedValue( strategy =  GenerationType.UUID)
    private UUID id ;


    @Column( nullable = false , length = 50 , unique = true )
    private String name ;

    @Column( nullable = false)
    private int price ;


    @Column(name ="num_of_classes" , nullable = false)
    private int numberOfClasses ;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}







