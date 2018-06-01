package com.zoctan.service;

import org.springframework.stereotype.Component;

@Component
public class ComputeServiceFallback implements ComputeService {

    @Override
    public String add(Integer a, Integer b) {
        return String.format("add %d + %d error", a, b);
    }
}