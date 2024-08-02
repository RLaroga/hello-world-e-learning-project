package com.helloWorld.helloWorld.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.helloWorld.helloWorld.entity.User;

import java.util.List;


public interface UserService extends IService<User> {

    List<User> selectUserList( );

    String saveUser(User user);

}
