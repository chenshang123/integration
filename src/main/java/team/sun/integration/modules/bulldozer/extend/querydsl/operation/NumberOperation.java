package team.sun.integration.modules.bulldozer.extend.querydsl.operation;

import cn.hutool.core.util.ArrayUtil;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;
import team.sun.integration.modules.bulldozer.extend.querydsl.ReflectionTable;

public class NumberOperation {
    /**
     * Math-操作类型
     */
    public static <N extends Number & Comparable<N>> BooleanExpression booleanOperation(
            NumberPath<N> path, String operation, Class<N> targetClass, String[] values) {
        if (null != path && StringUtils.hasLength(operation) && null != targetClass && !ArrayUtil.isEmpty(values)) {
            N[] nums = ReflectionTable.parseNumber(values, targetClass);
            if (nums != null) {
                switch (operation) {
                    case "gt":
                        return path.gt(nums[0]);
                    case "goe":
                        return path.goe(nums[0]);
                    case "lt":
                        return path.lt(nums[0]);
                    case "loe":
                        return path.loe(nums[0]);
                    case "between":
                        return path.between(nums[0], nums[1]);
                    case "notBetween":
                        return path.notBetween(nums[0], nums[1]);
                    case "in":
                        return path.in(nums);
                    case "notIn":
                        return path.notIn(nums);
                    case "ne":
                        return path.ne(nums[0]);
                    case "eq":
                        return path.eq(nums[0]);
                    case "isNull":
                        return path.isNull();
                    case "isNotNull":
                        return path.isNotNull();
                    case "like":
                        return path.like(values[0]);
                }
            }
        }
        return null;
    }

    public static <N extends Number & Comparable<N>> NumberExpression numberOperation(
            NumberPath<N> path, String operation, Class<N> targetClass, String[] values) {
        if (null != path && StringUtils.hasLength(operation) && null != targetClass && !ArrayUtil.isEmpty(values)) {
            N[] nums = ReflectionTable.parseNumber(values, targetClass);
            if (nums != null) {
                switch (operation) {
                    case "add":
                        return path.add(nums[0]);
                    case "subtract":
                        return path.subtract(nums[0]);
                    case "multiply":
                        return path.multiply(nums[0]);
                    case "divide":
                        return path.divide(nums[0]);
                    case "sqrt":
                        return path.sqrt();
                    case "abs":
                        return path.abs();
                    case "mod":
                        return path.mod(nums[0]);
                    case "as":
                        return path.as(values[0]);
                }
            }
        }
        return null;
    }

    /**
     * order-操作类型
     */
    public static OrderSpecifier orderOperation(NumberPath<?> path, String operation) {
        if (null != path && StringUtils.hasLength(operation)) {
            switch (operation) {
                case "asc":
                    return path.asc();
                case "desc":
                    return path.desc();
                case "ascNullsLast":
                    return path.asc().nullsLast();
                case "ascNullsFirst":
                    return path.asc().nullsFirst();
                case "descNullsLast":
                    return path.desc().nullsLast();
                case "descNullsFirst":
                    return path.desc().nullsFirst();
            }
        }
        return null;
    }
}
