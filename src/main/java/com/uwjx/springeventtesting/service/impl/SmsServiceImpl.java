package com.uwjx.springeventtesting.service.impl;

import com.uwjx.springeventtesting.event.UserLoginEvent;
import com.uwjx.springeventtesting.service.LogService;
import com.uwjx.springeventtesting.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService, ApplicationListener<UserLoginEvent> {


    @Override
    public void sendSms(String username) {
        log.warn("发送短信消息成功 {}" , username);
    }

    @Override
    public void onApplicationEvent(UserLoginEvent userLoginEvent) {
        log.warn("短信服务 接收到用户登录的事件");
        sendSms(userLoginEvent.getUsername());
    }
}
