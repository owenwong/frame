package com.yemast.frame.controller;

import com.github.pagehelper.PageInfo;
import com.yemast.frame.common.BaseRequest;
import com.yemast.frame.common.BaseResponse;
import com.yemast.frame.entity.User;
import com.yemast.frame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author owen
 * @since 17:18
 */
@RestController()
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 根据名称获取用户
     * @param name
     * @return
     */
    @RequestMapping("/get")
    public BaseResponse get(String name) {
        BaseResponse response = new BaseResponse();
        User user = userService.get(name);
        response.setData("user", user);
        return response;
    }

    /***
     * 获取用户列表
     * @param request
     * @return
     */
    @RequestMapping("/getList")
    public BaseResponse getList(BaseRequest request) {
        BaseResponse response = new BaseResponse();
        PageInfo<User> user = userService.getList(request);
        String str = "213345";
        response.setData("user", user);
        response.setData("str", str);
        return response;
    }

    /***
     * 保存用户
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/save")
    public BaseResponse save(String name, String address) {
        BaseResponse response = new BaseResponse();
        User user = userService.insert(name, address);
        response.setData("user", user);
        return response;
    }
}
