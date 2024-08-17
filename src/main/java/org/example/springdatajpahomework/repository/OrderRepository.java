package org.example.springdatajpahomework.repository;


import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findOrderByCustomer_CustomerId(Long customerId);
//    Set<Order> findOrderByCustomer(Customer customer, Pageable pageable);
}
