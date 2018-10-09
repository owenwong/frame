package com.yemast.frame.backend.request;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author WangWx
 * @date 2018年10月09日 15:16
 */
@Data
public class SaveUserRequest {

    @ApiParam(name = "name", value = "姓名")
    private String name;
    @ApiParam(name = "address", value = "地址")
    private String address;
}
