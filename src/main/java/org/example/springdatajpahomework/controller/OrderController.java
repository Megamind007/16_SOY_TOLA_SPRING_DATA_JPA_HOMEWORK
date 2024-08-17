package org.example.springdatajpahomework.controller;


import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.APIResponse;
import org.example.springdatajpahomework.model.eum.Status;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("save-order/{customerId}")
    public ResponseEntity<?> saveOrder(@PathVariable Long customerId,@RequestBody List<OrderRequest> orderRequest) {
        APIResponse<?> response  = APIResponse
                .builder()
                .message("Save order successfully")
                .data(orderService.saveOrder(customerId,orderRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{status}/{customerId}")
    public ResponseEntity<?> updateStatusOrder(@PathVariable Status status,@PathVariable Long customerId) {

        APIResponse<?> response  = APIResponse
                .builder()
                .message("Update status order successfully")
                .data(orderService.updateStatusOrder(status,customerId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("find-orders-by/{customerId}")
    public ResponseEntity<?> findOrderByCustomerId(@PathVariable Long customerId) {
        APIResponse<?> response  = APIResponse
                .builder()
                .message("Find order by customer id successfully")
                .data(orderService.findOrderByCustomerId(customerId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("find-order-by/{orderId}")
    public ResponseEntity<?> findOrderById(@PathVariable Long orderId) {
        APIResponse<?> response  = APIResponse
                .builder()
                .message("Find order by id successfully")
                .data(orderService.findOrderById(orderId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
