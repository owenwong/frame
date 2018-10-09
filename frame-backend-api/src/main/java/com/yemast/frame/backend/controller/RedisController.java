package com.yemast.frame.backend.controller;

import com.yemast.frame.core.common.BaseResponse;
import com.yemast.frame.core.expansion.config.RedisConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(value = "redis相关api", tags = "redis相关接口", description = "redis相关接口")
public class RedisController {

    @ApiOperation(value = "根据key查询值")
    @ApiImplicitParam(name = "key", value = "Key值", paramType = "query", required = true, dataType = "String")
    @GetMapping("/get")
    public BaseResponse get(String key) {
        return BaseResponse.ok(RedisConfig.get(key));
    }

    @ApiOperation(value = "保存redis数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "key", value = "Key值", paramType = "query", required = true, dataType = "String"), @ApiImplicitParam(name = "value", value = "value值", paramType = "query", required = true, dataType = "String")})
    @PostMapping("/push")
    public BaseResponse push(String key, String value) {
        RedisConfig.set(key, value);
        return BaseResponse.ok();
    }
}
