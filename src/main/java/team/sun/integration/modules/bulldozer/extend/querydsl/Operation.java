package team.sun.integration.modules.bulldozer.extend.querydsl;


import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;

public class Operation {

    /**
     * Quant-操作类型
     */
    public static BooleanExpression quantOperation(StringPath path, String operation) {
        if (null != path && StringUtils.hasLength(operation)) {
            if ("avg_max_col".equals(operation)) {

            } else if ("avg_min_col".equals(operation)) {

            } else if ("avg_avg_col".equals(operation)) {

            }
        }
        return null;
    }

    /**
     * Agg-操作类型
     */
    public static BooleanExpression aggOperation(StringPath path, String operation) {
        if (null != path && StringUtils.hasLength(operation)) {
            if ("agg_sum".equals(operation)) {

            } else if ("agg_max".equals(operation)) {

            } else if ("agg_min".equals(operation)) {

            } else if ("agg_avg".equals(operation)) {

            }
        }
        return null;
    }


}
