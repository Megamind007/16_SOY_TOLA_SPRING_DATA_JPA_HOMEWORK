package org.example.springdatajpahomework.service.serviceImp;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.repository.ProductRepository;
import org.example.springdatajpahomework.service.ProductService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
}
