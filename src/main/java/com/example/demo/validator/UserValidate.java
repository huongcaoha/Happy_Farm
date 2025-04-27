package com.example.demo.validator;

import com.example.demo.model.entity.Result;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserValidate {
    @Autowired
    private  UserService userService;

    public  Result checkRegister(User user) {
        boolean checkUsername = userService.checkUsernameExisted(user.getUsername());
        if(checkUsername) {
            return new Result(false, "Username is already taken");
        }else {
            boolean checkEmail = userService.checkEmailExisted(user.getEmail());
            if(checkEmail) {
                return new Result(false, "Email is already taken");
            }else {
                return new Result(true, "");
            }
        }
    }
}
