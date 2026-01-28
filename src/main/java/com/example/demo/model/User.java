package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "full_name", nullable = false)
    @NotBlank
    private String fullName;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
