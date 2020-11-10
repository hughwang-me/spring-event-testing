package com.uwjx.springeventtesting.service.impl;

import com.uwjx.springeventtesting.event.UserLoginEvent;
import com.uwjx.springeventtesting.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService , ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String login(String username) {
        log.warn("用户  {} 登录啦！！" , username);
        UserLoginEvent userLoginEvent = new UserLoginEvent(this , username);
        applicationEventPublisher.publishEvent(userLoginEvent);
        return username;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
