package com.zoctan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zoctan
 * @date 2018/06/18
 */
@FeignClient(value = "ribbonConsumer", fallback = RibbonConsumerServiceFallbackImpl.class)
public interface RibbonConsumerService {

    @GetMapping("/add2")
    String add2(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}