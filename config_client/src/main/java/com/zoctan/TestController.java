package com.zoctan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 绑定配置中的from属性
    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String from() {
        return String.format("I'm from %s", from);
    }
}