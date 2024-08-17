package org.example.springdatajpahomework.controller;

import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.request.ProductRequest;
import org.example.springdatajpahomework.model.dto.response.APIResponse;
import org.example.springdatajpahomework.model.eum.SortDirection;
import org.example.springdatajpahomework.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("find-all-products")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "productId") String sortBy, SortDirection sortDirection) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Find products successfully")
                .data(productService.findAll(pageNo, pageSize, sortBy, sortDirection))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("find-product-by/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Find product successfully")
                .data(productService.findById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("save-product")
    public ResponseEntity<?> save(@RequestBody ProductRequest productRequest) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Save product successfully")
                .data(productService.save(productRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("delete-product-by/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Delete product successfully")
                .data(productService.deleteById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update-product-by/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Update product successfully")
                .data(productService.updateById(id, productRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
