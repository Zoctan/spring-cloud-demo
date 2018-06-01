package com.zoctan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class ComputeService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add(Integer a, Integer b) {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    public String addFallback(Integer a, Integer b) {
        return String.format("add %d + %d error", a, b);
    }
}