package org.example.springdatajpahomework.service.serviceImp;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.ProductRequest;
import org.example.springdatajpahomework.model.dto.response.ProductResponse;
import org.example.springdatajpahomework.model.entity.Product;
import org.example.springdatajpahomework.model.eum.SortDirection;
import org.example.springdatajpahomework.repository.ProductRepository;
import org.example.springdatajpahomework.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAll(Integer pageNo, Integer pageSize, String sortBy, SortDirection sortDirection) {
        Sort.Direction direction = sortDirection == SortDirection.ASC ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, direction, sortBy);
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent().stream().map(Product::toResponse).toList();
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? product.toResponse() : null;
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        Product product = productRepository.save(productRequest.toEntity());
        return product.toResponse();
    }

    @Override
    public Void deleteById(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public ProductResponse updateById(Long id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        product.setProductId(id);
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setUnitPrice(productRequest.getUnitPrice());
        productRepository.save(product);
        return product.toResponse();
    }
}
