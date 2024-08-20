package com.helloWorld.helloWorld.controller;

import com.helloWorld.helloWorld.common.annotation.IgnoreToken;
import com.helloWorld.helloWorld.request.RequestLogin;
import com.helloWorld.helloWorld.response.ResponseBase;
import com.helloWorld.helloWorld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;

    @IgnoreToken
    @PostMapping("/login")
    public ResponseBase<String> login(@RequestBody RequestLogin requestLogin) {
        return ResponseBase.ok(userService.logInit(requestLogin));
    }
}
