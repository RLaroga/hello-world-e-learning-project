package com.helloWorld.helloWorld.controllers;

import com.helloWorld.helloWorld.requests.RequestLogin;
import com.helloWorld.helloWorld.responses.ResponseBase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginController {
    @PostMapping
    public ResponseBase<String> login(@RequestBody RequestLogin requestLogin) {
        return null;
    }
}
