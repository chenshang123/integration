package team.sun.integration.modules.base.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前后端交互对象
 */
@Api("分页请求对象")
public class PageDTO implements Serializable {

    protected static final int DEFAULT_PAGE_NUM = 1;
    protected static final int DEFAULT_PAGE_SIZE = 10;
    protected static final int DEFAULT_PAGE_MAX_SIZE = 100;
    private static final long serialVersionUID = -7742633354158106128L;
    @ApiModelProperty(value = "页码")
    protected int page = DEFAULT_PAGE_NUM;
    @ApiModelProperty(value = "每页条数")
    protected int size = DEFAULT_PAGE_SIZE;
    @ApiModelProperty(value = "排序字段信息")
    protected List<OrderItem> orders = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }
}
