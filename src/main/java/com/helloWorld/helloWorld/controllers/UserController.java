package com.helloWorld.helloWorld.controllers;

import com.github.pagehelper.PageInfo;
import com.helloWorld.helloWorld.entities.User;
import com.helloWorld.helloWorld.responses.ResponseBase;
import com.helloWorld.helloWorld.services.UserService;
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

    @GetMapping("/list")
    public ResponseBase<List<User>> list() {
        System.out.println("Before mapper! ");
        List<User> userList = userService.selectUserList();

        ResponseBase<List<User>> responseData = ResponseBase.ok();
        if ( userList == null ) {
            System.out.println("User List is Null");
            return responseData;
        }

        System.out.println("User List is Not Null");
        responseData.setData( userList );
        responseData.setTotal( new PageInfo<>( userList ).getTotal() );
        return responseData;
    }
}
