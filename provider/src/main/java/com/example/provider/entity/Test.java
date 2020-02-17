package com.example.provider.entity;

import lombok.Data;

/**
 * @Description: Test 实体类
 * @Author jdwu
 * @Date 2020/2/13
**/
@Data
public class Test {
    int key;
    String value;

    public Test(int key, String value){
        this.key = key;
        this.value = value;
    }
}
