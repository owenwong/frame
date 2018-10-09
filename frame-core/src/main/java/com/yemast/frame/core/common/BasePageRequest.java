package com.yemast.frame.core.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;

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
    @Range(min = 1, max = 99, message = "pageSize为1-99之间")
    @ApiModelProperty(value = "条数", name = "pageSize", example = "10")
    private Integer pageSize;
    /**
     * 页数
     */
    @NotNull(message = "pageNum不能为空")
    @ApiModelProperty(value = "页数", name = "pageNum", example = "1")
    private Integer pageNum;

}
