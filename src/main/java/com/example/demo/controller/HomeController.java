package com.example.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(HttpServletResponse resp , HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            String isLogin = null ;
            String role = null ;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userLogin")) {
                    isLogin = cookie.getValue();
                }else if(cookie.getName().equals("userRole")){
                    role = cookie.getValue();
                }
            }
            if (isLogin == null || role == null || isLogin.equals("false") || !role.equals("USER")) {
                return "login";
            }
        }else {
            return "login";
        }
        return "home";
    }
}
