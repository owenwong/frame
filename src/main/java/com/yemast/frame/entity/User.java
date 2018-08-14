package com.yemast.frame.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author WangWx
 * @since 2018年08月09日 13:28
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地址
     */
    private String address;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
