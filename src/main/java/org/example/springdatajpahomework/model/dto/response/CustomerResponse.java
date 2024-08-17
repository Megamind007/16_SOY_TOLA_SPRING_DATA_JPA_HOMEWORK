package org.example.springdatajpahomework.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private Long customerId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private EmailResponse emailResponse;
    private Set<OrderResponse> orderResponses;
}
