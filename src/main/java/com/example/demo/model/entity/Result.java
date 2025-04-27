package com.example.demo.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Result {
  private boolean status ;
  private String description ;
}
