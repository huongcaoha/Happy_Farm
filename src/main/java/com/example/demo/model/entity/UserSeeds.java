package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "userSeeds")
public class UserSeeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "seedsId")
    private Seeds seeds ;
    private int quantity ;


}
