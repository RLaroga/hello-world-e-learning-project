package com.helloWorld.helloWorld.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.helloWorld.helloWorld.entities.User;

import java.util.List;


public interface UserService extends IService<User> {

    List<User> selectUserList( );

    String saveUser(User user);

}
