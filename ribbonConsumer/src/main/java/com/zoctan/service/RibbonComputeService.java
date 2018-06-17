package com.zoctan.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@Service
public class RibbonComputeService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add(Integer a, Integer b) {
        return restTemplate.getForEntity("http://COMPUTESERVICE/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    public String addFallback(Integer a, Integer b) {
        return String.format("add %d + %d error", a, b);
    }
}