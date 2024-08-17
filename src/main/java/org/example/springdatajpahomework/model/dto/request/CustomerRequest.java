package org.example.springdatajpahomework.model.dto.request;
import lombok.*;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Email;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequest {
    private String customerName;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer toEntity(){
        return new Customer(null,this.customerName,this.address,this.phoneNumber,new Email(null,this.email),null);
    }
}
