package com.helloWorld.helloWorld.controller;

import com.github.pagehelper.PageInfo;
import com.helloWorld.helloWorld.entity.User;
import com.helloWorld.helloWorld.response.ResponseBase;
import com.helloWorld.helloWorld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

//    @GetMapping("/list")
//    public ResponseBase<List<User>> list() {
//        List<User> userList = userService.selectUserList();
//
//        ResponseBase<List<User>> responseData = ResponseBase.ok();
//        if ( userList == null ) {
//            return responseData;
//        }
//        responseData.setData( userList );
//        responseData.setTotal( new PageInfo<>( userList ).getTotal() );
//        return responseData;
//    }

    @GetMapping("/list")
    public String list(User user) {
        return "HELLO";
    }
}
