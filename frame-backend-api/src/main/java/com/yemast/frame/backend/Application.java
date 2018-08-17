package com.yemast.frame.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 后台接口启动
 *
 * @author WangWX
 * @date 2018/8/17 11:11
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.yemast.frame.backend", "com.yemast.frame.core"})
@MapperScan("com.yemast.frame.core.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
