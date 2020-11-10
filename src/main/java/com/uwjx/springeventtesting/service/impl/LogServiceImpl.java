package com.uwjx.springeventtesting.service.impl;

import com.uwjx.springeventtesting.event.UserLoginEvent;
import com.uwjx.springeventtesting.service.LogService;
import com.uwjx.springeventtesting.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogServiceImpl implements LogService, ApplicationListener<UserLoginEvent> {


    @Override
    public void addLog(String username) {
        log.warn("增加用户登录日志成功 {}" , username);
    }

    @Override
    public void onApplicationEvent(UserLoginEvent userLoginEvent) {
        log.warn("日志服务 接收到用户登录的事件");
        addLog(userLoginEvent.getUsername());
    }
}
