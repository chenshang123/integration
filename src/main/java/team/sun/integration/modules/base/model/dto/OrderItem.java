package team.sun.integration.modules.base.model.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 需要进行排序的字段
     */
    private String column;
    /**
     * 是否正序排列，默认 true
     */
    private boolean asc = true;

    public OrderItem(String column, boolean asc) {
        this.column = column;
        this.asc = asc;
    }

    public static OrderItem asc(String column) {
        return build(column, true);
    }

    public static OrderItem desc(String column) {
        return build(column, false);
    }

    public static List<OrderItem> ascs(String... columns) {
        return Arrays.stream(columns).map(OrderItem::asc).collect(Collectors.toList());
    }

    public static List<OrderItem> descs(String... columns) {
        return Arrays.stream(columns).map(OrderItem::desc).collect(Collectors.toList());
    }

    private static OrderItem build(String column, boolean asc) {
        return new OrderItem(column, asc);
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
