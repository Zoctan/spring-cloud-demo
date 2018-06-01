package com.dilang.zoctan.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 绑定配置服务中配置的from属性
    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String getFrom() {
        return String.format("I'm from %s", from);
    }
}