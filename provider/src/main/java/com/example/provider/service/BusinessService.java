package com.example.provider.service;

import com.example.provider.entity.Test;
import org.springframework.stereotype.Service;

/**
 * @Description: 主业务接口
 * @Author jdwu
 * @Date 2020/2/13
**/
@Service
public interface BusinessService {
    String getMessage();

    void insert(Test test);

    void testTransaction() throws Exception;
}
