package org.example.springdatajpahomework.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.springdatajpahomework.model.dto.response.EmailResponse;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "email")
@ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;

    public EmailResponse toResponse() {
        return new EmailResponse(this.id, this.email);
    }
}
