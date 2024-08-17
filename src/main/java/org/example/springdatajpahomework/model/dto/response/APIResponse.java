package org.example.springdatajpahomework.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse <T>{
    private String message;
    private T data;
    private HttpStatus status;
    private LocalDateTime time;
}
