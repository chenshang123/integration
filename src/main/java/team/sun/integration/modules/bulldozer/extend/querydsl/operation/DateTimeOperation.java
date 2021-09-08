package team.sun.integration.modules.bulldozer.extend.querydsl.operation;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimePath;
import org.springframework.util.StringUtils;

public class DateTimeOperation {
    /**
     * date-操作类型
     */
    public static <T extends Comparable> BooleanExpression dateTimeOperation(DateTimePath<T> path, String operation, T value[]) {
        if (null != path && StringUtils.hasLength(operation)) {
            switch (operation) {
                case "after":
                    return path.after(value[0]);
                case "before":
                    return path.before(value[0]);
                case "between":
                    return path.between(value[0], value[2]);
                case "notBetween":
                    return path.notBetween(value[0], value[2]);
                case "gt":
                    return path.gt(value[0]);
                case "goe":
                    return path.goe(value[0]);
                case "lt":
                    return path.lt(value[0]);
                case "loe":
                    return path.loe(value[0]);
                case "in":
                    return path.in(value);
                case "notIn":
                    return path.notIn(value);
                case "isNull":
                    return path.isNull();
                case "isNotNull":
                    return path.isNotNull();
            }
        }
        return null;
    }
}
