package org.example.springdatajpahomework.model.entity;
import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.request.eum.Status;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_tb")
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
    private Set<ProductOrder> productOrders;
}
