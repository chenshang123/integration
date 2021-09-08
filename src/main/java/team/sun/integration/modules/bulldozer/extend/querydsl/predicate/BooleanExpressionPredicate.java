package team.sun.integration.modules.bulldozer.extend.querydsl.predicate;

import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;
import team.sun.integration.modules.bulldozer.extend.querydsl.criteria.Criteria;
import team.sun.integration.modules.bulldozer.extend.querydsl.operation.NumberOperation;
import team.sun.integration.modules.bulldozer.extend.querydsl.operation.StringOperation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class BooleanExpressionPredicate {

    private Criteria criteria;

    public BooleanExpressionPredicate(Criteria criteria) {
        this.criteria = criteria;
    }

    public BooleanExpression getBooleanExpression(Criteria criteria, String keyType, PathBuilder<?> entityPath) {
        if (StringUtils.hasLength(keyType) && StringUtils.hasLength(criteria.getKey())) {
            if (keyType.equals(java.lang.Integer.class.getTypeName()) || keyType.equals(int.class.getTypeName())) {
                NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), java.lang.Integer.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Integer.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Short.class.getTypeName()) || keyType.equals(short.class.getTypeName())) {
                NumberPath<Short> path = entityPath.getNumber(criteria.getKey(), java.lang.Short.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Short.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Long.class.getTypeName()) || keyType.equals(long.class.getTypeName())) {
                NumberPath<Long> path = entityPath.getNumber(criteria.getKey(), java.lang.Long.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Long.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Double.class.getTypeName()) || keyType.equals(double.class.getTypeName())) {
                NumberPath<Double> path = entityPath.getNumber(criteria.getKey(), java.lang.Double.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Double.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Float.class.getTypeName()) || keyType.equals(float.class.getTypeName())) {
                NumberPath<Float> path = entityPath.getNumber(criteria.getKey(), java.lang.Float.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Float.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Character.class.getTypeName()) || keyType.equals(char.class.getTypeName())) {
                ComparablePath<Character> path = entityPath.getComparable(criteria.getKey(), java.lang.Character.class);
            } else if (keyType.equals(java.lang.Byte.class.getTypeName()) || keyType.equals(byte.class.getTypeName())) {
                NumberPath<Byte> path = entityPath.getNumber(criteria.getKey(), java.lang.Byte.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.lang.Byte.class, criteria.getValues());
            } else if (keyType.equals(java.lang.Boolean.class.getTypeName()) || keyType.equals(boolean.class.getTypeName())) {
                BooleanPath path = entityPath.getBoolean(criteria.getKey());

            } else if (keyType.equals(java.math.BigDecimal.class.getTypeName())) {
                NumberPath<BigDecimal> path = entityPath.getNumber(criteria.getKey(), java.math.BigDecimal.class);
                return NumberOperation.booleanOperation(path, criteria.getOperation(), java.math.BigDecimal.class, criteria.getValues());
            } else if (keyType.equals(java.lang.String.class.getTypeName())) {
                StringPath path = entityPath.getString(criteria.getKey());
                StringOperation.booleanOperation(path, criteria.getOperation(), criteria.getValues());
            } else if (keyType.equals(java.time.LocalDateTime.class.getTypeName())) {
                DateTimePath<LocalDateTime> path = entityPath.getDateTime(criteria.getKey(), java.time.LocalDateTime.class);

            } else if (keyType.equals(java.util.Date.class.getTypeName())) {
                DateTimePath<Date> path = entityPath.getDateTime(criteria.getKey(), java.util.Date.class);

            } else if (keyType.equals(java.util.Collection.class.getTypeName())) {

            } else if (keyType.equals(java.util.List.class.getTypeName())) {

            } else if (keyType.equals(java.util.Set.class.getTypeName())) {

            }
        }

        return null;
    }


    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

}
