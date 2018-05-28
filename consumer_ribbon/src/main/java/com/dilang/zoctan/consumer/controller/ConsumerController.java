package com.dilang.zoctan.consumer.controller;

import com.dilang.zoctan.consumer.service.ComputeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private ComputeService computeService;

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return computeService.add(a, b);
    }
}