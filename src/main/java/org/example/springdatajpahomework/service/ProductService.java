package org.example.springdatajpahomework.service;

import org.example.springdatajpahomework.model.dto.request.ProductRequest;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;
import org.example.springdatajpahomework.model.eum.SortDirection;

import javax.swing.text.html.Option;
import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll(Integer pageNo, Integer pageSize, String sortBy, SortDirection sortDirection);

    ProductResponse findById(Long id);

    ProductResponse save(ProductRequest productRequest);

    Void deleteById(Long id);

    ProductResponse updateById(Long id, ProductRequest productRequest);
}
