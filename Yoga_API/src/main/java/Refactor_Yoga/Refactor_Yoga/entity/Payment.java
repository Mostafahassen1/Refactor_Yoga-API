
package Refactor_Yoga.Refactor_Yoga.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Mutability;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name ="payment")
public class Payment{

    @ManyToOne
    @JoinColumn( name= "client_id")
    private Client client ;

    @ManyToOne
    @JoinColumn(name ="packagePlan_id")
    private PackagePlan packagePlan ;


    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id ;

    @Column(name ="payment_date" , nullable = false)
    private LocalDateTime paymentDate ;

    public Payment() {
    }

    public Payment(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PackagePlan getPackagePlan() {
        return packagePlan;
    }

    public void setPackagePlan(PackagePlan packagePlan) {
        this.packagePlan = packagePlan;
    }
}



