package com.example.demo.model.entity;

import com.example.demo.model.constant.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Role role;
    private double balance;
    private boolean status;
    private LocalDateTime created_at;


}
