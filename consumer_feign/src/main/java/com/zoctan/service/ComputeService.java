package com.zoctan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ComputeServiceFallback.class)
public interface ComputeService {

    @GetMapping("/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}