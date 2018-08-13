package com.yemast.frame.service;

import com.yemast.frame.common.BaseRequest;
import com.yemast.frame.entity.User;
import com.yemast.frame.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务层
 *
 * @author WangWx
 * @since 2018年08月09日 13:45
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /***
     * 根据名称获取用户
     * @param name
     * @return
     */
    public User get(String name) {
        return userMapper.get(name);
    }

    /***
     * 获取用户列表
     *
     * @param request
     * @return
     */
    public List<User> getList(BaseRequest request) {
        List<User> userList = userMapper.getList();
        return userList;
    }

    /***
     * 保存用户
     *
     * @param name
     * @param address
     * @return
     */
    @Transactional
    public User insert(String name, String address) {
        int id = userMapper.insert(name, address);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        return user;
    }
}
