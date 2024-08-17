package org.example.springdatajpahomework.model.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.entity.Order;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.entity.ProductOrder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long quantity;
    private Long productId;

    public ProductOrder toEntity(Order order,Product product){
        return new ProductOrder(null,order,product,this.quantity);
    }
}
