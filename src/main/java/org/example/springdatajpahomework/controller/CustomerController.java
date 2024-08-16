package org.example.springdatajpahomework.controller;
import lombok.AllArgsConstructor;
import org.example.springdatajpahomework.model.response.APIResponse;
import org.example.springdatajpahomework.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;


@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        APIResponse<?> response = APIResponse
                .builder()
                .message("Find customers successfully")
                .data(customerService.findAll())
                .status(HttpStatus.OK)
                .time(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
