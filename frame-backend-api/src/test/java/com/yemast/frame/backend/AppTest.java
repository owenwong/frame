package com.yemast.frame.backend;

import com.yemast.frame.core.entity.User;
import com.yemast.frame.core.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
