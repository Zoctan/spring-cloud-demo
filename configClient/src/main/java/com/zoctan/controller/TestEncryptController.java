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

    // 配置文件中加密的数据库密码
    @Value("${spring.datasource.password}")
    private String dbPassword;

    @GetMapping("/dbPassword")
    public String dbPassword() {
        return String.format("Database Password: %s", dbPassword);
    }
}