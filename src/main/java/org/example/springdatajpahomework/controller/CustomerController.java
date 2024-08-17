package org.example.springdatajpahomework.controller;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.eum.SortDirection;
import org.example.springdatajpahomework.model.dto.request.CustomerRequest;
import org.example.springdatajpahomework.model.dto.response.APIResponse;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("find-all-customers")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "customerId") String sortBy,SortDirection sortDirection) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Find customers successfully")
                .data(customerService.findAll(pageNo,pageSize,sortBy,sortDirection))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("find-customer-by/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Find customer successfully")
                .data(customerService.findById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("save-customer")
    public ResponseEntity<?> save(@RequestBody CustomerRequest customerRequest) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Save customer successfully")
                .data(customerService.save(customerRequest))
                .status(HttpStatus.CREATED)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("delete-customer-by/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Delete customer successfully")
                .data(customerService.deleteById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("update-customer-by/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody CustomerRequest customerRequest) {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Update customer successfully")
                .data(customerService.updateById(id,customerRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
