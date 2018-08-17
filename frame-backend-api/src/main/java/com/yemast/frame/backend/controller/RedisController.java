package com.yemast.frame.backend.controller;

import com.yemast.frame.core.common.BaseResponse;
import com.yemast.frame.core.expansion.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis控制器
 *
 * @author WangWx
 * @date 2018年08月15日 15:27
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @RequestMapping("/get")
    public BaseResponse get() {
        RedisConfig.set("yemast:frame", "frame");
        return BaseResponse.ok(RedisConfig.get("yemast:frame"));
    }
}
