package com.zoctan.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(ComputeController.class);

    @Resource
    private EurekaInstanceConfig eurekaInstanceConfig;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer after = a + b;
        logger.info("/add, instanceId:{} , host:{} , result:{}",
                eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false), after);
        return String.format("Result: %d, from port: %d", after, serverPort);
    }
}