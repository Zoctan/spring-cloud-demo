package com.zoctan.controller;

import com.zoctan.service.FeignComputeService;
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
    private FeignComputeService computeService;

    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return computeService.add(a, b);
    }
}