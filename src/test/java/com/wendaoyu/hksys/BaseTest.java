package com.wendaoyu.hksys;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.wendaoyu.hksys.dao")
//@AutoConfigureMockMvc
public class BaseTest {
}
