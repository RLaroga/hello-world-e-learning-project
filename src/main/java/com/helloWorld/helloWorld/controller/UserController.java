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

    @GetMapping("/list")
    public ResponseBase<List<User>> list(User user) {
        List<User> userList = userService.selectUserList(user);

        ResponseBase<List<User>> responseData = ResponseBase.ok();
        if ( userList == null ) {
            return responseData;
        }
        responseData.setData( userList );
        responseData.setTotal( new PageInfo<>( userList ).getTotal() );
        return responseData;
    }

}
