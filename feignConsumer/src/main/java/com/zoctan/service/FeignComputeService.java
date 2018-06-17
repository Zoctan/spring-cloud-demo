package com.zoctan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@FeignClient(value = "computeService", fallback = FeignComputeServiceFallbackImpl.class)
public interface FeignComputeService {

    @GetMapping("/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}