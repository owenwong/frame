package com.yemast.frame.mapper;

import com.yemast.frame.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author WangWx
 * @since 2018年08月09日 13:27
 */
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User get(@Param("name") String name);

    @Select("select * from user")
    List<User> getList();

    @Insert("insert into user(name,address) values (#{name},#{address})")
    int insert(@Param("name") String name, @Param("address") String address);

}
