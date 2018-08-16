package com.yemast.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 系统启动入口
 *
 * @Author WangWX2
 * @Date 2018/8/13 13:16
 */
// 异步任务开关
@EnableAsync
// 定时任务开关
@EnableScheduling
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.yemast.frame.controller", "com.yemast.frame.service", "com.yemast.frame.expansion"})
@MapperScan(basePackages = {"com.yemast.frame.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
