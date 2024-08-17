package org.example.springdatajpahomework.service;
import org.example.springdatajpahomework.model.dto.response.CustomerResponse;
import org.example.springdatajpahomework.model.eum.SortDirection;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> findAll(Integer pageNo, Integer pageSize, String sortBy, SortDirection sortDirection);

    CustomerResponse findById(Long id);

    CustomerResponse save(CustomerRequest customerRequest);

    Void deleteById(Long id);

    CustomerResponse updateById(Long id, CustomerRequest customerRequest);
}
