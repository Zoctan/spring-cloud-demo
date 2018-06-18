package com.zoctan.controller;

import com.zoctan.service.RibbonComputeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@RestController
public class RibbonConsumerController {

    @Resource
    private RibbonComputeService computeService;

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return computeService.add(a, b);
    }

    /**
     * 加法接口2，测试服务追踪
     */
    @GetMapping("/add2")
    public String add2(@RequestParam Integer a, @RequestParam Integer b) {
        return "computeService: " + computeService.add(a, b);
    }
}