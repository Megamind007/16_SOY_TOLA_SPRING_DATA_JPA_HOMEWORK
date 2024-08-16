package org.example.springdatajpahomework.service.serviceImp;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.repository.OrderRepository;
import org.example.springdatajpahomework.service.OrderService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {
    private OrderRepository orderRepository;
}
