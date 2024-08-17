package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.dto.request.OrderRequest;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.eum.Status;

import java.util.List;

public interface OrderService {
    Object saveOrder(Long customerId, List<OrderRequest> orderRequest);

    Object updateStatusOrder(Status status, Long customerId);

    Object findOrderByCustomerId(Long customerId);

    OrderResponse findOrderById(Long orderId);
}
