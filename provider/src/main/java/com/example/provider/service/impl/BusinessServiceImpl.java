package com.example.provider.service.impl;

import com.example.provider.entity.Test;
import com.example.provider.mapper.TestMapper;
import com.example.provider.service.BusinessService;
import com.example.provider.service.TestTransactionService;
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
    private TestTransactionService testTransactionService;

    @Override
    public String getMessage() {
        return "测试";
    }

    @Transactional
    @Override
    public void insert(Test test) {
        testMapper.insert(test);
    }

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void testTransaction() throws Exception {
        testMapper.insert(new Test(1, "test"));
        testTransactionService.insert();
        throw new Exception("就报个异常 怎么滴");
    }

    //
   // @Scheduled(cron = "0 */1 * * * ?")  //定时器1分钟一次
    public void testSchedule(){
        System.out.println("--------testSchedule-----------");
    }
}
