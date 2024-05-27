package com.helloWorld.helloWorld.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.helloWorld.helloWorld.entity.User;
import com.helloWorld.helloWorld.mapper.UserMapper;
import com.helloWorld.helloWorld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
