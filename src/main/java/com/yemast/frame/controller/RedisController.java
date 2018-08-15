package com.yemast.frame.controller;

import com.yemast.frame.common.BaseController;
import com.yemast.frame.common.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/get")
    public BaseResponse get() {
        BaseResponse response = new BaseResponse();
        redisTemplate.opsForValue().set("yemast:redis", "redis");
        response.setData("redis", redisTemplate.opsForValue().get("yemast:redis"));
        return response;
    }
}
