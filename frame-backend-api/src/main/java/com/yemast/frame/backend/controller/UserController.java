package com.yemast.frame.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemast.frame.core.common.BasePageRequest;
import com.yemast.frame.core.common.BaseResponse;
import com.yemast.frame.core.entity.User;
import com.yemast.frame.core.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据名称获取用户
     *
     * @param name
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @RequestMapping("/get")
    public BaseResponse get(String name) {
        User user = userService.selectOne(new QueryWrapper<User>().lambda().like(User::getName, name));
        return BaseResponse.ok(user);
    }

    /**
     * 获取用户列表
     *
     * @param request
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @RequestMapping("/getList")
    public BaseResponse getList(@Valid BasePageRequest request) {
        IPage<User> userList = userService.selectPage(new Page<User>(request.getPageNum(), request.getPageSize()), null);
        return BaseResponse.ok(userList);
    }

    /**
     * 保存用户
     *
     * @param name
     * @param address
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @RequestMapping("/save")
    public BaseResponse save(String name, String address) {
        User user = new User(name, address);
        userService.insert(user);
        return BaseResponse.ok().setData("user", user);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return com.yemast.frame.core.common.BaseResponse
     */
    @RequestMapping("/del")
    public BaseResponse del(Integer id) {
        userService.deleteById(id);
        return BaseResponse.ok();
    }
}
