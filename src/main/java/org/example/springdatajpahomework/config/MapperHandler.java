package org.example.springdatajpahomework.config;

import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Email;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class MapperHandler {
    public Customer toEntity(CustomerRequest customerRequest,Long emailId){
        Customer customer = new Customer();
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setAddress(customerRequest.getAddress());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        Email email = new Email();
        email.setId(emailId);
        email.setEmail(customerRequest.getEmail());
        customer.setEmail(email);
        return customer;
    }
}
