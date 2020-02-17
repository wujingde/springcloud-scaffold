package com.example.provider.controller;

import com.example.provider.entity.Test;
import com.example.provider.service.BusinessService;
import com.netflix.client.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 提供服务 前端控制器
 * @Author jdwu
 * @Date 2020/2/13
**/
@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private BusinessService businessService;

    private int count = 0;

    @Autowired
    private HttpServletRequest request;

    /**
    * @Description: 测试 ribbon 重试机制 、 feign 熔断机制
     * @Param: []
     * @Return: java.lang.String
     * @Author: jdwu
     * @Date: 2020/2/13
    **/
    @RequestMapping("/index")
    public String index(){
        try{
            Thread.sleep(3000l);
        }catch(Exception e){

        }
        System.out.println("请求路径"+ request.getRequestURL());
        System.out.println(Thread.currentThread().getName()+"调用第"+ ++count +"次");
        return businessService.getMessage();
    }

    /**
    * @Description:  分布式事务参与方
     * @Param: [test]
     * @Return: void
     * @Author: jdwu
     * @Date: 2020/2/13
    **/
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insert(@RequestBody Test test){
         businessService.insert(test);
    }

    /**
     * @Description:  测试接口之间的事务
     * @Param: [test]
     * @Return: void
     * @Author: jdwu
     * @Date: 2020/2/13
     **/
    @RequestMapping(value = "/testTransaction", method = RequestMethod.GET)
    public void testTransaction(){
        try {
            businessService.testTransaction();
        } catch (Exception e) {
            System.out.println("----测试接口之间的事务完毕------");
        }
    }

}
