package com.example.consumer.entity;

import lombok.Data;

/**
 * @Description: Test 实体类
 * @Author jdwu
 * @Date 2020/2/13
**/
@Data
public class Test {
    int key; // key
    String value; //value

    public Test(int key, String value){
        this.key = key;
        this.value = value;
    }
}
