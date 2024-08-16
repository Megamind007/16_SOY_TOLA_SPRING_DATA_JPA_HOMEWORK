package org.example.springdatajpahomework.service.serviceImp;


import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.repository.CustomerRepository;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
