package com.yemast.frame.controller;

import com.yemast.frame.common.BaseController;
import com.yemast.frame.common.BaseResponse;
import com.yemast.frame.config.ServerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangWx
 * @since 2018年08月10日 14:46
 */
@RestController()
@RequestMapping("/config")
@Slf4j
public class ConfigController extends BaseController {

    @Autowired
    private ServerProperties serverProperties;

    /***
     * 根据名称获取用户
     * @return
     */
    @RequestMapping("/get")
    public BaseResponse get() {
        BaseResponse response = new BaseResponse();
        response.setData("config", serverProperties.getUrl());
        return response;
    }
}