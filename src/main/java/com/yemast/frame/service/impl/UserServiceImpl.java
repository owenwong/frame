package com.yemast.frame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yemast.frame.entity.User;
import com.yemast.frame.mapper.UserMapper;
import com.yemast.frame.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务层
 *
 * @author WangWx
 * @since 2018年08月14日 8:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
