package com.example.provider.mapper;

import com.example.provider.entity.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: TestMapper  接口
 * @Author jdwu
 * @Date 2020/2/13
 **/
@Mapper
public interface TestMapper {
    @Insert(" insert into t_test (`key`, `value`) values (#{test.key}, #{test.value}) ")
    void insert(@Param("test") Test test);

    @Insert(" insert into t_test_1 (`key`, `value`) values (#{test.key}, #{test.value}) ")
    void insertTest1(@Param("test") Test test);
}
