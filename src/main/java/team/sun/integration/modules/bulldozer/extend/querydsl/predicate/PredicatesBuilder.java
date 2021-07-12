package team.sun.integration.modules.bulldozer.extend.querydsl.predicate;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import team.sun.integration.modules.bulldozer.extend.querydsl.ReflectionKit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PredicatesBuilder {

    private String tableName;

    private List<Criteria> params;

    public PredicatesBuilder with(String key, String operation, String[] value) {
        params.add(new Criteria(key, operation, value));
        return this;
    }

    public BooleanExpression build() {
        Class<?> entityClass = ReflectionKit.CLASS_NAME_FIELD_CACHE.get(tableName);
        if (params.size() == 0 && null == entityClass) {
            return null;
        }
        PathBuilder entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());
        List<BooleanExpression> predicates = params.stream().map(param -> {
            Predicate predicate = new Predicate(param);
            return predicate.getPredicate(entityClass, entityPath);
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression predicate : predicates) {
            result = result.and(predicate);
        }
        return result;
    }
}
