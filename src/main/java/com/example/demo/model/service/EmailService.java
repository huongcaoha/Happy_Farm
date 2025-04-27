package com.example.demo.model.service;

import com.example.demo.model.entity.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    public String getPassCode() {
        StringBuilder passCode = new StringBuilder();
        for (int i = 1; i <= 6; i++) {
            passCode.append((int)(Math.random() * 10)); // Số ngẫu nhiên từ 0 đến 9
        }
        return passCode.toString();
    }
}

