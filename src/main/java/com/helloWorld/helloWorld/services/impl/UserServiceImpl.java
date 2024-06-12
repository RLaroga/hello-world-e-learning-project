package com.helloWorld.helloWorld.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.helloWorld.helloWorld.entities.User;
import com.helloWorld.helloWorld.mappers.UserMapper;
import com.helloWorld.helloWorld.services.UserService;
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
        User userExist = this.getUserByUsername( user.getUsername());
        if ( null != userExist ) {
            return "Username already exists";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(9);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreatedTime(LocalDateTime.now());
        baseMapper.insert(user);
        return "Registration Successful";
    }

    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
