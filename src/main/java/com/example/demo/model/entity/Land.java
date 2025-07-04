package com.example.demo.model.entity;

import com.example.demo.model.constant.TypeLand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "lands")
public class Land {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nameLand ;
    private TypeLand typeLand;
    private double price ;
    private float efficiency ;
    private String description ;
    private String image ;
    private boolean status = true;
    private LocalDateTime createDate = LocalDateTime.now() ;

}
