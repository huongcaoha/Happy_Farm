package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "seeds")
public class Seeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String seedsName;
    private double price;
    private int developmentTime ;
    private String description ;
    private double postHarvestPrice ;
    private String image ;
    private boolean status = true ;
    private LocalDateTime createDate = LocalDateTime.now() ;

}
