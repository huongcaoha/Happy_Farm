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
@Table(name = "userLands")
public class UserLand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "landId")
    private Land land;

    @ManyToOne
    @JoinColumn(name = "seedsId")
    private Seeds seeds;
    private boolean status = true;
    private LocalDateTime harvestTime = null;
    private LocalDateTime createdDate = LocalDateTime.now() ;

}
