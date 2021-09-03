package team.sun.integration.config.base.model.dto;

import java.io.Serial;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前后端交互对象
 */
@Api("分页请求对象")
public class PageDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7742633354158106128L;

    protected static final int DEFAULT_PAGE_NUM = 1;
    protected static final int DEFAULT_PAGE_SIZE = 10;
    protected static final int DEFAULT_PAGE_MAX_SIZE = 100;

    @ApiModelProperty(value = "页码")
    protected int page = DEFAULT_PAGE_NUM;
    @ApiModelProperty(value = "每页条数")
    protected int pageSize = DEFAULT_PAGE_SIZE;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = Math.min(DEFAULT_PAGE_MAX_SIZE, pageSize);
    }
}
