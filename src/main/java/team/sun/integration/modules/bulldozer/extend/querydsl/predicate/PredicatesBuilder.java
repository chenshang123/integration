package team.sun.integration.modules.bulldozer.extend.querydsl.predicate;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import team.sun.integration.modules.bulldozer.extend.querydsl.ReflectionKit;
import team.sun.integration.modules.bulldozer.extend.querydsl.criteria.SearchCriteria;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PredicatesBuilder {

    private SearchCriteria searchCriteria;

    public PredicatesBuilder(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public BooleanExpression build() {
        Class<?> entityClass = ReflectionKit.CLASS_NAME_FIELD_CACHE.get(searchCriteria.getTableName());
        Map<String, String> KeyMap = KeyMap(entityClass, searchCriteria.getKeys());

        if (KeyMap == null || searchCriteria == null || searchCriteria.getCriteriaList().size() == 0 || null == entityClass) {
            return null;
        }
        PathBuilder<?> entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());

        List<BooleanExpression> booleanExpressions = searchCriteria.getCriteriaList().stream().map(criteria -> {
            BooleanExpressionPredicate booleanExpressionPredicate = new BooleanExpressionPredicate(criteria);
            return booleanExpressionPredicate.getBooleanExpression(criteria, KeyMap.get(criteria.getKey()), entityPath);
        }).filter(Objects::nonNull).collect(Collectors.toList());

        BooleanExpression result = Expressions.asBoolean(true).isTrue();
        for (BooleanExpression booleanExpression : booleanExpressions) {
            result = result.and(booleanExpression);
        }

        return result;
    }

    private Map<String, String> KeyMap(Class<?> entityClass, List<String> keys){
        if(!keys.isEmpty()){
            List<Field> fields = ReflectionKit.CLASS_FIELD_CACHE.get(entityClass);
            Map<String, String> result = new HashMap<>(keys.size());
            if(!fields.isEmpty()){
                for (Field field : fields) {
                    for (String key : keys) {
                        if (field.getName().equals(key)) {
                            result.put(key, field.getAnnotatedType().toString());
                        }
                    }
                }
                return result;
            }
        }
        return null;
    }

    public SearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
