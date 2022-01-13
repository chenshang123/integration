package team.sun.integration.common.base.model.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 分页请求对象
 */
@Api("分页查询返回对象")
public class PageRet implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 总数量
     */
    @ApiModelProperty(value = "总数量")
    private long count;
    /**
     * 分页数据
     */
    @ApiModelProperty(value = "分页数据")
    private List<?> data = Collections.emptyList();


    public PageRet(List<?> data, long count) {
        this.data = data;
        this.count = count;
    }

    public PageRet() {

    }

    public long getTotalCount() {
        return count;
    }

    public List<?> getData() {
        return data;
    }
}
