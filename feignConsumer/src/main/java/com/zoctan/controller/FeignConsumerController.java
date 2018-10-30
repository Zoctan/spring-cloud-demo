package com.zoctan.controller;

import com.zoctan.service.FeignComputeService;
import com.zoctan.service.RibbonConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@RestController
public class FeignConsumerController {

    @Resource
    private FeignComputeService feignComputeService;

    @Resource
    private RibbonConsumerService ribbonConsumerService;

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return feignComputeService.add(a, b);
    }

    @GetMapping("/add2")
    public String add2(@RequestParam Integer a, @RequestParam Integer b) {
        return "ribbonConsumer => " + ribbonConsumerService.add2(a, b);
    }
}