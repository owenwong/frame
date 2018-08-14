package com.yemast.frame.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yemast.frame.common.BaseRequest;
import com.yemast.frame.common.BaseResponse;
import com.yemast.frame.entity.User;
import com.yemast.frame.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @Param [name]
     * @return com.yemast.frame.common.BaseResponse
     */
    @RequestMapping("/get")
    public BaseResponse get(String name) {
        BaseResponse response = new BaseResponse();
        User user = userService.selectOne(new QueryWrapper<User>().lambda().like(User::getName, name));
        response.setData("user", user);
        return response;
    }

    /**
     * 获取用户列表
     *
     * @Param [request]
     * @return com.yemast.frame.common.BaseResponse
     */
    @RequestMapping("/getList")
    public BaseResponse getList(BaseRequest request) {
        BaseResponse response = new BaseResponse();
        IPage<User> userList = userService.selectPage(new Page<User>(request.getPageNum(), request.getPageSize()), null);
        response.setData("user", userList);
        return response;
    }

    /**
     * 保存用户
     *
     * @Param [name, address]
     * @return com.yemast.frame.common.BaseResponse
     */
    @RequestMapping("/save")
    public BaseResponse save(String name, String address) {
        BaseResponse response = new BaseResponse();
        User user = new User(name, address);
        userService.insert(user);
        response.setData("user", user);
        return response;
    }

    /**
     * 删除用户
     *
     * @return com.yemast.frame.common.BaseResponse
     * @Param [id]
     */
    @RequestMapping("/del")
    public BaseResponse del(Integer id) {
        BaseResponse response = new BaseResponse();
        userService.deleteById(id);
        response.setSuccess("删除成功");
        return response;
    }
}
