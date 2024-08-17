package org.example.springdatajpahomework.service.serviceImp;


import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.config.MapperHandler;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.model.dto.response.OrderResponse;
import org.example.springdatajpahomework.model.entity.Customer;
import org.example.springdatajpahomework.model.entity.Email;
import org.example.springdatajpahomework.model.eum.SortDirection;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.repository.CustomerRepository;
import org.example.springdatajpahomework.repository.EmailRepository;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepository;
    private final EmailRepository emailRepository;
    private final MapperHandler mapperHandler;


    @Override
    public List<CustomerResponse> findAll(Integer pageNo, Integer pageSize, String sortBy, SortDirection sortDirection) {
        Sort.Direction direction = sortDirection == SortDirection.ASC ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, direction, sortBy);
        Page<Customer> customers = customerRepository.findAll(pageable);
        return customers.getContent().stream().map(Customer::toResponse).toList();
    }

    @Override
    public CustomerResponse findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer == null) {
            return null;
        }
        return customer.toResponse();
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer customer = mapperHandler.toEntity(customerRequest, emailRepository.save(new Email(null, customerRequest.getEmail())).getId());
        customerRepository.save(customer);
        return customer.toResponse();
    }

    @Override
    public Void deleteById(Long id) {
        customerRepository.deleteById(id);
        return null;
    }

    @Override
    public CustomerResponse updateById(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElse(null);
        System.out.println("Customer: " + customer);
        if (customer == null) {
            return null;
        }
        customer.setCustomerName(customerRequest.getCustomerName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setAddress(customerRequest.getAddress());
        customer.getEmail().setEmail(customerRequest.getEmail());
        customerRepository.save(customer);
        return customer.toResponse();
    }
}
