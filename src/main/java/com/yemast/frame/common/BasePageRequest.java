package com.yemast.frame.common;

import com.yemast.frame.util.Const;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 基础分页请求
 *
 * @author WangWx
 * @date 2018年08月14日 17:01
 */
@Data
public class BasePageRequest extends BaseRequest {

    /**
     * 条数
     */
    @NotNull(message = "pageSize不能为空")
    @Pattern(regexp = "^[0-9]{1,2}$", message = "pageSize输入有误")
    private Integer pageSize;
    /**
     * 页数
     */
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;

    public Integer getPageSize() {
        return this.pageSize = pageSize == 0 ? Const.DEFAULT_PAGE_SIZE : pageSize;
    }
}
