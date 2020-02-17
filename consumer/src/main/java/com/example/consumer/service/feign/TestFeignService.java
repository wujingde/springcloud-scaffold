package com.example.consumer.service.feign;


import com.example.consumer.entity.Test;
import com.netflix.discovery.EurekaIdentityHeaderFilter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: feign 客户端
 * @Author jdwu
 * @Date 2020/2/12
**/
//@FeignClient(name = "PROVIDER-SERVICE", fallback = TestFeignServiceImpl.class)
    // TODO  feign 接口 是否需要抽成 api    网关尚未正确使用
@FeignClient(name="gateway", url = "http://localhost:8093/provider-service", fallback = TestFeignServiceImpl.class)
//consumer-service
public interface TestFeignService {
    /**
    * @Description: 测试 get 请求
     * @Param: []
     * @Return: java.lang.String
     * @Author: jdwu
     * @Date: 2020/2/12
    **/
    @GetMapping("/provider/index")
    String getMessage();

    /**
    * @Description: 测试 post 请求
     * @Param: [test]
     * @Return: void
     * @Author: jdwu
     * @Date: 2020/2/12
    **/
    @PostMapping(value="/provider/insert", consumes = "application/json")
    void insert(@RequestBody Test test);
}
