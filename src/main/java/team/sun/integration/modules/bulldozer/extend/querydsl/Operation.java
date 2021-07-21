package team.sun.integration.modules.bulldozer.extend.querydsl;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;

public class Operation {
    /**
     * 通用-操作类型
     */
    public static BooleanExpression commonOperation(StringPath path, String operation, String value){
        if(null != path && StringUtils.hasLength(operation)){
            if("eq".equals(operation)){
                path.eq(value);
            }else if("ne".equals(operation)){

            }else if("gt".equals(operation)){

            }else if("goe".equals(operation)){

            }else if("lt".equals(operation)){

            }else if("loe".equals(operation)){

            }else if("between".equals(operation)){

            }else if("notBetween".equals(operation)){

            }else if("in".equals(operation)){

            }else if("notIn".equals(operation)){

            }else if("like".equals(operation)){

            }else if("notLike".equals(operation)){

            }else if("likeIgnoreCase".equals(operation)){

            }else if("startsWith".equals(operation)){

            }else if("startsWithIgnoreCase".equals(operation)){

            }else if("endsWith".equals(operation)){

            }else if("endsWithIgnoreCase".equals(operation)){

            }else if("as".equals(operation)){

            }else if("isNull".equals(operation)){

            }else if("isNotNull".equals(operation)){

            }else if("trim".equals(operation)){

            }
        }
        return null;
    }

    /**
     * 字符串-操作类型
     */
    public static BooleanExpression stringOperation(StringPath path, String operation, String value[]){
        if(null != path && StringUtils.hasLength(operation)){
            if("eq".equals(operation)){
                path.eq(value[0]);
            }else if("ne".equals(operation)){
                path.ne(value[0]);
            }else if("gt".equals(operation)){
                path.gt(value[0]);
            }else if("goe".equals(operation)){
                path.goe(value[0]);
            }else if("lt".equals(operation)){
                path.lt(value[0]);
            }else if("loe".equals(operation)){
                path.loe(value[0]);
            }else if("between".equals(operation)){
                path.between(value[0], value[1]);
            }else if("notBetween".equals(operation)){
                path.notBetween(value[0], value[1]);
            }else if("in".equals(operation)){
                path.in(value);
            }else if("notIn".equals(operation)){
                path.notIn(value);
            }else if("like".equals(operation)){
                path.like(value[0]);
            }else if("notLike".equals(operation)){
                path.notLike(value[0]);
            }else if("likeIgnoreCase".equals(operation)){
                path.likeIgnoreCase(value[0]);
            }else if("startsWith".equals(operation)){
                path.startsWith(value[0]);
            }else if("startsWithIgnoreCase".equals(operation)){
                path.startsWithIgnoreCase(value[0]);
            }else if("endsWith".equals(operation)){
                path.endsWith(value[0]);
            }else if("endsWithIgnoreCase".equals(operation)){
                path.endsWithIgnoreCase(value[0]);
            }else if("as".equals(operation)){
                path.as(value[0]);
            }else if("isNull".equals(operation)){
                path.isNull();
            }else if("isNotNull".equals(operation)){
                path.isNotNull();
            }else if("isEmpty".equals(operation)){
                path.isEmpty();
            }else if("isNotEmpty".equals(operation)){
                path.isNotEmpty();
            }else if("trim".equals(operation)){
                path.trim();
            }else if("toLowerCase".equals(operation)){
                path.toLowerCase();
            }else if("toUpperCase".equals(operation)){
                path.toUpperCase();
            }

        }
        return null;
    };
    /**
     * Math-操作类型
     */
    public static <N extends Number & Comparable<N>> NumberExpression mathOperation(NumberPath<?> path, String operation, N value[]){
        if(null != path && StringUtils.hasLength(operation)){
//          //eq
            //ne
            //like
            //path.mod(value[0]);
            if("gt".equals(operation)){
                path.gt(value[0]);
            }else if("goe".equals(operation)){
                path.goe(value[0]);
            }else if("lt".equals(operation)){
                path.lt(value[0]);
            }else if("loe".equals(operation)){
                path.loe(value[0]);
            }else if("between".equals(operation)){
                path.between(value[0], value[1]);
            }else if("notBetween".equals(operation)){
                path.notBetween(value[0], value[1]);
            }else if("in".equals(operation)){
                path.in(value);
            }else if("notIn".equals(operation)){
                path.notIn(value);
            }else  if("isNull".equals(operation)){
                path.isNull();
            }else if("isNotNull".equals(operation)){
                path.isNotNull();
            }else if("add".equals(operation)){
                path.add(value[0]);
            }else if("subtract".equals(operation)){
                path.subtract(value[0]);
            }else if("multiply".equals(operation)){
                path.multiply(value[0]);
            }else if("divide".equals(operation)){
                path.divide(value[0]);
            }else if("sqrt".equals(operation)){
                path.sqrt();
            }else if("abs".equals(operation)){
                path.abs();
            }

        }
        return null;
    }
    /**
     * date-操作类型
     */
    public static <N> DateTimeExpression dateOperation(DateTimePath path, String operation, N value[]){
        if(null != path && StringUtils.hasLength(operation)){
            if("after".equals(operation)){
                path.after((Comparable) value[0]);
            }else if("before".equals(operation)){
                path.before((Comparable) value[0]);
            }
        }
        return null;
    }
    /**
     * Quant-操作类型
     */
    public static BooleanExpression quantOperation(StringPath path, String operation){
        if(null != path && StringUtils.hasLength(operation)){
            if("avg_max_col".equals(operation)){

            }else if("avg_min_col".equals(operation)){

            }else if("avg_avg_col".equals(operation)){

            }
        }
        return null;
    }
    /**
     * Agg-操作类型
     */
    public static BooleanExpression aggOperation(StringPath path, String operation){
        if(null != path && StringUtils.hasLength(operation)){
            if("agg_sum".equals(operation)){

            }else if("agg_max".equals(operation)){

            }else if("agg_min".equals(operation)){

            }else if("agg_avg".equals(operation)){

            }
        }
        return null;
    }
    /**
     * order-操作类型
     */
    public static OrderSpecifier orderOperation(Path<?> path, String operation){
        if(null != path && StringUtils.hasLength(operation)){
            if("asc".equals(operation)){

            }else if("desc".equals(operation)){

            }else if("asc_nullsLast".equals(operation)){

            }else if("asc_nullsFirst".equals(operation)){

            }else if("desc_nullsLast".equals(operation)){

            }else if("desc_nullsFirst".equals(operation)){

            }
        }
        return null;
    }


}
