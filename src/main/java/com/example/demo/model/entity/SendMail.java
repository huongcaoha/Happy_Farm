package com.example.demo.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SendMail {
    private boolean status;
    private String passCode;
}
