package com.example.consumer.service.impl;

import com.example.consumer.entity.Test;
import com.example.consumer.mapper.TestMapper;
import com.example.consumer.service.BusinessService;
import com.example.consumer.service.feign.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 主业务实现类
 * @Author jdwu
 * @Date 2020/2/13
**/
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TestFeignService testFeignService;

    /**
     * @Description: 测试事务 demo
     * @Author: jdwu
     * @Date: 2020/2/12
    **/
    @Transactional
    //@LcnTransaction
    @Override
    public void insert() {
        testMapper.insert(new Test(1, "consumer"));
       // testFeignService.insert(new Test(2, "provider"));
    }
}
