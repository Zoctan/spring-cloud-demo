package com.zoctan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zoctan
 * @date 2018/06/18
 */
@RestController
public class TestEncryptController {

    // 配置文件中加密的密码
    @Value("${password}")
    private String password;

    @GetMapping("/password")
    public String getPassword() {
        return String.format("Password: %s", password);
    }
}