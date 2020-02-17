package com.example.consumer.controller;

import com.example.consumer.service.BusinessService;
import com.example.consumer.service.feign.TestFeignService;
import com.example.consumer.service.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: feign 组件测试controller
 * @Author jdwu
 * @Date 2020/2/12
**/
@RestController
@RequestMapping("feign")
public class FeignTestController {
    @Autowired
    private TestFeignService testFeignService;

    @Autowired
    private BusinessService businessService;

    /**
     * @Description: 远程调用测试
     * @Author: jdwu
     * @Date: 2020/2/12
    **/
    @RequestMapping("/test")
    public String getMessage(){
        return testFeignService.getMessage();
    }

    @RequestMapping("/test-tm")
    public void testLcnTm(){
        businessService.insert();
    }
}
