package com.example.provider.service.impl;

import com.example.provider.entity.Test;
import com.example.provider.mapper.TestMapper;
import com.example.provider.service.TestTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 * @Author jdwu
 * @Date 2020/2/16
 **/
@Service
public class TestTransactionServiceImpl implements TestTransactionService {
    @Autowired
    private TestMapper testMapper;

    @Transactional(rollbackFor=Exception.class)
    @Override
    public void insert() {
        testMapper.insertTest1(new Test(1, "test11"));
    }
}
