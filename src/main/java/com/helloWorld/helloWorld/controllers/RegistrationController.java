package com.helloWorld.helloWorld.controllers;

import com.helloWorld.helloWorld.entities.User;
import com.helloWorld.helloWorld.responses.ResponseBase;
import com.helloWorld.helloWorld.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class RegistrationController {

    private final UserService userService;

//    @IgnoreToken
    @PostMapping("/register")
    public ResponseBase<String> register(@RequestBody User user) {
        return ResponseBase.ok( userService.saveUser(user) );
    }

}
