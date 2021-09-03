package team.sun.integration.modules.bulldozer.extend.querydsl.operation;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.util.StringUtils;

public class StringOperation {
    /**
     * 字符串-操作类型
     */
    public static BooleanExpression booleanOperation(StringPath path, String operation, String value[]){
        if(null != path && StringUtils.hasLength(operation)){
            switch (operation) {
                case "eq":
                    return path.eq(value[0]);
                case "ne":
                    return path.ne(value[0]);
                case "gt":
                    return path.gt(value[0]);
                case "goe":
                    return path.goe(value[0]);
                case "lt":
                    return path.lt(value[0]);
                case "loe":
                    return path.loe(value[0]);
                case "between":
                    return path.between(value[0], value[1]);
                case "notBetween":
                    return path.notBetween(value[0], value[1]);
                case "in":
                    return path.in(value);
                case "notIn":
                    return path.notIn(value);
                case "like":
                    return path.like(value[0]);
                case "notLike":
                    return path.notLike(value[0]);
                case "likeIgnoreCase":
                    return path.likeIgnoreCase(value[0]);
                case "startsWith":
                    return path.startsWith(value[0]);
                case "startsWithIgnoreCase":
                    return path.startsWithIgnoreCase(value[0]);
                case "endsWith":
                    return path.endsWith(value[0]);
                case "endsWithIgnoreCase":
                    return path.endsWithIgnoreCase(value[0]);
                case "isNull":
                    return path.isNull();
                case "isNotNull":
                    return path.isNotNull();
                case "isEmpty":
                    return path.isEmpty();
                case "isNotEmpty":
                    return path.isNotEmpty();
            }

        }
        return null;
    }
    public static StringExpression stringOperation(StringPath path, String operation, String value[]){
        if(null != path && StringUtils.hasLength(operation)){
            switch (operation) {
                case "as":
                    return path.as(value[0]);
                case "trim":
                    return path.trim();
                case "toLowerCase":
                    return path.toLowerCase();
                case "toUpperCase":
                    return path.toUpperCase();
            }
        }
        return null;
    }

    /**
     * order-操作类型
     */
    public static OrderSpecifier orderOperation(StringPath path, String operation){
        if(null != path && StringUtils.hasLength(operation)){
            switch (operation) {
                case "asc":
                    return path.asc();
                case "desc":
                    return path.desc();
                case "asc_nullsLast":
                    return path.asc().nullsLast();
                case "asc_nullsFirst":
                    return path.asc().nullsFirst();
                case "desc_nullsLast":
                    return path.desc().nullsLast();
                case "desc_nullsFirst":
                    return path.desc().nullsFirst();
            }
        }
        return null;
    }
}
