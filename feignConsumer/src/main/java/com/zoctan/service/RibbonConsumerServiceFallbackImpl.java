package com.zoctan.service;

import org.springframework.stereotype.Component;

/**
 * @author Zoctan
 * @date 2018/06/18
 */
@Component
public class RibbonConsumerServiceFallbackImpl implements RibbonConsumerService {

    @Override
    public String add2(Integer a, Integer b) {
        return "trace to ribbon consumer error";
    }
}