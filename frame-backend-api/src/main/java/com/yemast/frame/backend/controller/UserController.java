package com.yemast.frame.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemast.frame.backend.request.SaveUserRequest;
import com.yemast.frame.core.common.BasePageRequest;
import com.yemast.frame.core.common.BaseResponse;
import com.yemast.frame.core.entity.User;
import com.yemast.frame.core.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户控制器
 *
 * @Author WangWX
 * @Date 2018/8/13 18:37
 */
@RestController()
@RequestMapping("/user")
@Slf4j
@Api(value = "用户相关api", tags = "用户相关接口", description = "用户相关接口")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据名称获取用户
     *
     * @param name
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @ApiOperation(value = "根据姓名查询用户信息")
    @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", required = true, dataType = "String")
    @GetMapping("/get")
    public BaseResponse get(String name) {
        User user = userService.getOne(new QueryWrapper<User>().lambda().like(User::getName, name));
        return BaseResponse.ok(user);
    }

    /**
     * 获取用户列表
     *
     * @param request
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @ApiOperation(value = "查询用户信息")
    @GetMapping("/getList")
    public BaseResponse getList(@Valid BasePageRequest request) {
        IPage<User> userList = userService.page(new Page<>(request.getPageNum(), request.getPageSize()), null);
        return BaseResponse.ok(userList);
    }

    /**
     * 保存用户
     *
     * @param request
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @ApiOperation(value = "保存用户信息")
    @PostMapping("/save")
    public BaseResponse save(SaveUserRequest request) {
        User user = new User(request.getName(), request.getAddress());
        userService.save(user);
        return BaseResponse.ok().setData("user", user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @ApiOperation(value = "删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path", required = true, dataType = "int")
    @GetMapping("/del/{id}")
    public BaseResponse del(@PathVariable Integer id) {
        userService.removeById(id);
        return BaseResponse.ok();
    }
}
