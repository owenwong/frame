package com.yemast.frame.core.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 基础分页数据参数
 *
 * @author WangWx
 * @date 2018年08月14日 17:01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BasePageRequest extends BaseRequest {

    /**
     * 条数
     */
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    /**
     * 页数
     */
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;

}
