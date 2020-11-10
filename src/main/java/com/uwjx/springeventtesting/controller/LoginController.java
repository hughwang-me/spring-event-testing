package com.uwjx.springeventtesting.controller;

import com.uwjx.springeventtesting.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "account")
public class LoginController {

    @Resource
    LoginService loginService;

    @GetMapping(value = "login")
    public String login(@RequestParam(value = "username" , required = true) String username){
        log.warn("用户登录啦");

        return loginService.login(username);
    }
}
