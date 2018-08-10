package com.yemast.frame;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WangWx
 * @since 2018年08月07日 13:46
 */
@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.yemast.frame.controller", "com.yemast.frame.service", "com.yemast.frame.expansion"})
@MapperScan(basePackages = {"com.yemast.frame.mapper"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
