package com.helloWorld.helloWorld.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.helloWorld.helloWorld.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends IService<User> {

    List<User> selectUserList( );

}
