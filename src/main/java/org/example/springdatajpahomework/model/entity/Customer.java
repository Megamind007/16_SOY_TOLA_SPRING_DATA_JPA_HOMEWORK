package org.example.springdatajpahomework.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.model.dto.response.EmailResponse;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;

import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "email_id")
    private Email email;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();

    public CustomerResponse toResponse() {
        EmailResponse emailResponse = (this.email != null) ? this.email.toResponse() : null;
        Set<OrderResponse> orderResponses = new HashSet<>();
        for (Order order : this.orders) {
            orderResponses.add(order.toResponse());
        }
        return new CustomerResponse(this.customerId, this.customerName, this.address, this.phoneNumber, emailResponse,orderResponses);
    }
}
