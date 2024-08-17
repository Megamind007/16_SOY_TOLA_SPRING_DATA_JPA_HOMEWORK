package org.example.springdatajpahomework;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "Spring Data Jpa Homework",
        version = "v1"
        ))
@SpringBootApplication
public class SpringDataJpaHomeworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaHomeworkApplication.class, args);
    }

}
