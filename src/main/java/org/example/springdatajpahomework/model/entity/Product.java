package org.example.springdatajpahomework.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double unitPrice;
    private String description;

    @OneToMany(mappedBy = "product")
    @ToString.Exclude
    private Set<ProductOrder> productOrders;

    public ProductResponse toResponse() {
        return new ProductResponse(productId, productName, unitPrice, description);
    }
}
