package com.helloWorld.helloWorld.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.helloWorld.helloWorld.entity.User;
import com.helloWorld.helloWorld.mapper.UserMapper;
import com.helloWorld.helloWorld.request.RequestLogin;
import com.helloWorld.helloWorld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> selectUserList() {

        System.out.println("USER SERVICE IMPL");

        return userMapper.selectUserList();
    }


    @Override
    public String saveUser(User user) {
        User userExist = this.getUserByUsername(user.getUsername());
        if (null != userExist) {
            return "Username already exists";
        }
        BCryptPasswordEncoder encoder = getDefaultPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreatedTime(LocalDateTime.now());
        baseMapper.insert(user);
        return "Registration Successful";
    }

    @Override
    public String logInit(RequestLogin requestLogin) {
        BCryptPasswordEncoder encoder = getDefaultPasswordEncoder();
        User user = userMapper.findByUsername(requestLogin.getUsername());
        boolean isPasswordMatch = encoder.matches(requestLogin.getPassword(), user.getPassword());
        if (isPasswordMatch) {
            return "Successfully logged in";
        } else {
            return "Incorrect password";
        }
    }

    private User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    private BCryptPasswordEncoder getDefaultPasswordEncoder() {
        return new BCryptPasswordEncoder(9);
    }


}
