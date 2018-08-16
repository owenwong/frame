package com.yemast.frame.controller;

import com.yemast.frame.common.BaseController;
import com.yemast.frame.common.BaseResponse;
import com.yemast.frame.expansion.config.RedisConfig;
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
public class RedisController extends BaseController {

    @RequestMapping("/get")
    public BaseResponse get() {
        BaseResponse response = new BaseResponse();
        RedisConfig.set("yemast:frame", "frame");
        response.setData("redis", RedisConfig.get("yemast:frame"));
        return response;
    }
}
