package com.example.consumer.service.feign;

import com.example.consumer.entity.Test;
import org.springframework.stereotype.Component;

@Component
public class TestFeignServiceImpl implements TestFeignService {

    @Override
    public String getMessage() {
        return "nonono";
    }

    @Override
    public void insert(Test test) {
        //return "nonono";
    }
}
