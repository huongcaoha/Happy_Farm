package com.example.demo.controller;

import com.example.demo.model.constant.Role;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Result;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.EmailService;
import com.example.demo.model.service.UserService;
import com.example.demo.validator.UserValidate;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserValidate userValidate;
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/authRegister")
    public String authRegister() {
        return "authRegister";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password ,
                        HttpServletResponse response, HttpServletRequest request) {
        User user = userService.login(username, password);
        if (user != null) {
            Cookie cookie1 = new Cookie("userLogin", "true");
            Cookie cookie2 = new Cookie("username", username);
            Cookie cookie3 = new Cookie("password", password);

            cookie1.setMaxAge(3600);
            cookie2.setMaxAge(3600);
            cookie3.setMaxAge(3600);

            cookie1.setPath("/");
            cookie2.setPath("/");
            cookie3.setPath("/");
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);

            if(user.getRole() == Role.ADMIN){
                Cookie cookie4 = new Cookie("userRole", "ADMIN");
                cookie4.setMaxAge(3600);
                cookie4.setPath("/");
                response.addCookie(cookie4);
                return "redirect:/admin";
            }
            else {
                Cookie cookie4 = new Cookie("userRole", "USER");
                cookie4.setMaxAge(3600);
                cookie4.setPath("/");
                response.addCookie(cookie4);
                return "redirect:/";
            }
        }else {
            request.setAttribute("error","Username or password is incorrect");
            return "redirect:/auth/login";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto userDto ,
                           RedirectAttributes redirectAttributes ,
                           BindingResult bindingResult , Model model, HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "redirect:/auth/register";
        }


        User user = userService.convertUserDtoToUser(userDto);
        Result checkRegister = userValidate.checkRegister(user);

        if(checkRegister.isStatus()){
            String passCode = emailService.getPassCode();
            emailService.sendSimpleEmail(user.getEmail(),"Mã đăng ký tài khoản",passCode);
            HttpSession session = request.getSession();
            session.setAttribute("userRegister",user);
            session.setAttribute("passCode",passCode);
            session.setMaxInactiveInterval(60*30);
            return "redirect:/auth/authRegister";
        }else {
            redirectAttributes.addFlashAttribute("error", checkRegister.getDescription());
            return "redirect:/auth/register";
        }

    }

    @PostMapping("/authRegister")
    public String authRegister(HttpServletRequest request , @RequestParam String passCode , Model model , RedirectAttributes redirectAttributes) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userRegister");
        String code = session.getAttribute("passCode").toString();
        if(user != null && !code.isEmpty() && code.equals(passCode)) {
            int id = userService.insert(user);
            if(id == -1){
            model.addAttribute("error","Đăng ký không thành công");
            return "redirect:/auth/register";
            }else {
            redirectAttributes.addFlashAttribute("messageSuccess","Đăng ký thành công");
            return "redirect:/auth/login";
            }
        }else {
            model.addAttribute("error","Pass code ko đúng !");
            redirectAttributes.addFlashAttribute("error" , "Mã pass code ko chính xác");
            return "redirect:/auth/authRegister";
        }
    }

}
