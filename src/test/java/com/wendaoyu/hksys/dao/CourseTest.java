package com.wendaoyu.hksys.dao;

import com.wendaoyu.hksys.BaseTest;
import com.wendaoyu.hksys.domain.Course;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class CourseTest extends BaseTest {
    @Resource
    CourseMapper courseMapper;

    @Test
    public void test_insert(){
        Course course = new Course();
        course.setClassName("软件卓越1401");
        course.setCourseName("计算机网络基础");
        course.setDiscription("《计算机网络基础》共分8个模块，主要内容包括认识计算机网络、网络数据通信基础、网络体系结构与协议、组建局域网、互联网的使用、网络的管理、网络管理与网络安全以及案例分析——校园网的建设。");
        course.setTeacherId(1);
        Assert.assertEquals(1, courseMapper.insert(course));
    }
}
