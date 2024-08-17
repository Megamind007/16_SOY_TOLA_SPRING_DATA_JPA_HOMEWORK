package org.example.springdatajpahomework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;
import org.example.springdatajpahomework.model.eum.Status;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_tb")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private Float totalAmount;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private Set<ProductOrder> productOrders;

    public OrderResponse toResponse() {
        Set<ProductResponse> productResponses = new HashSet<>();
        for(ProductOrder productOrder : productOrders){
            productResponses.add(productOrder.getProduct().toResponse());
        }
        return new OrderResponse(this.orderId, this.orderDate, this.totalAmount, this.status, productResponses);
    }
}
