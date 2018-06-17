package com.zoctan.service;

import org.springframework.stereotype.Component;

/**
 * @author Zoctan
 * @date 2018/06/17
 */
@Component
public class FeignComputeServiceFallbackImpl implements FeignComputeService {

    @Override
    public String add(Integer a, Integer b) {
        return String.format("add %d + %d error", a, b);
    }
}