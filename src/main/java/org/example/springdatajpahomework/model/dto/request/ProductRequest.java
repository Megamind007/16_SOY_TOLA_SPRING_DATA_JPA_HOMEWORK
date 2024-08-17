package org.example.springdatajpahomework.model.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.entity.Product;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;
    private Double unitPrice;
    private String description;

    public Product toEntity(){
        return new Product(null,this.productName,this.unitPrice,this.description,null);
    }
}
