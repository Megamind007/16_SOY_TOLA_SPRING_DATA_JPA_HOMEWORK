package org.example.springdatajpahomework.model.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String customerName;
    private String address;
    private String phoneNumber;
    private String email;

}
