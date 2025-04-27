package com.example.demo.model.service;

import com.example.demo.model.constant.Role;
import com.example.demo.model.dao.UserDao;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements IService<User>,AuthService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean checkUsernameExisted(String username) {
        return userDao.checkUsernameExisted(username);
    }

    @Override
    public boolean checkEmailExisted(String email) {
        return userDao.checkEmailExisted(email);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    public User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setRole(Role.USER);
        user.setBalance(1000);
        user.setStatus(true);
        user.setCreatedDate(LocalDateTime.now());
        return user;

    }
}
