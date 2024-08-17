package org.example.springdatajpahomework.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.eum.Status;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime orderDate;
    private Float totalAmount;
    private Status status;
    private Set<ProductResponse> products;
}
