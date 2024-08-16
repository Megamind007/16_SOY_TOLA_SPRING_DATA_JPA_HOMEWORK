package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
