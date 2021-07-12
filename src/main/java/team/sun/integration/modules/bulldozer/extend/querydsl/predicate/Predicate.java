package team.sun.integration.modules.bulldozer.extend.querydsl.predicate;

import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;
import team.sun.integration.modules.bulldozer.extend.querydsl.ReflectionKit;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Predicate {

    private Criteria criteria;

    public Predicate(Criteria criteria) {
        this.criteria = criteria;
    }
    public BooleanExpression getPredicate(Class<?> entityClass, PathBuilder<?> entityPath) {
        String keyType = getKeyType(entityClass, criteria.getKey());
        return null;
    }
    public BooleanExpression getPath(String keyType, PathBuilder<?> entityPath) {

        if(!StringUtils.hasLength(keyType) || !StringUtils.hasLength(criteria.getKey())){

        }else if(keyType.equals(java.lang.Integer.class.getTypeName()) || keyType.equals(int.class.getTypeName())){
            NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), java.lang.Integer.class);
        }else if(keyType.equals(java.lang.Short.class.getTypeName()) || keyType.equals(short.class.getTypeName())){
            NumberPath<Short> path = entityPath.getNumber(criteria.getKey(), java.lang.Short.class);
        }else if(keyType.equals(java.lang.Long.class.getTypeName()) || keyType.equals(long.class.getTypeName())){
            NumberPath<Long> path = entityPath.getNumber(criteria.getKey(), java.lang.Long.class);
        }else if(keyType.equals(java.lang.Double.class.getTypeName()) || keyType.equals(double.class.getTypeName())){
            NumberPath<Double> path = entityPath.getNumber(criteria.getKey(), java.lang.Double.class);
        }else if(keyType.equals(java.lang.Float.class.getTypeName()) || keyType.equals(float.class.getTypeName())){
            NumberPath<Float> path = entityPath.getNumber(criteria.getKey(), java.lang.Float.class);
        }else if(keyType.equals(java.lang.Character.class.getTypeName()) || keyType.equals(char.class.getTypeName())){
            ComparablePath<Character> path = entityPath.getComparable(criteria.getKey(), java.lang.Character.class);
        }else if(keyType.equals(java.lang.Byte.class.getTypeName()) || keyType.equals(byte.class.getTypeName())){
            NumberPath<Byte> path = entityPath.getNumber(criteria.getKey(), java.lang.Byte.class);
        }else if(keyType.equals(java.lang.Boolean.class.getTypeName()) || keyType.equals(boolean.class.getTypeName())){
            BooleanPath path = entityPath.getBoolean(criteria.getKey());
        }else if(keyType.equals(java.math.BigDecimal.class.getTypeName())){
            NumberPath<BigDecimal> path = entityPath.getNumber(criteria.getKey(), java.math.BigDecimal.class);
        }else if(keyType.equals(java.lang.String.class.getTypeName())){
            StringPath path = entityPath.getString(criteria.getKey());
        }else if(keyType.equals(java.util.Collection.class.getTypeName())){

        }else if(keyType.equals(java.util.List.class.getTypeName())){

        }else if(keyType.equals(java.util.Set.class.getTypeName())){

        }else if(keyType.equals(java.time.LocalDateTime.class.getTypeName())){
            DateTimePath<LocalDateTime> path = entityPath.getDateTime(criteria.getKey(), java.time.LocalDateTime.class);
        }else if(keyType.equals(java.util.Date.class.getTypeName())){
            DateTimePath<Date> path = entityPath.getDateTime(criteria.getKey(), java.util.Date.class);
        }


        return null;
    }


    private String getKeyType(Class<?> entityClass,String key){
        List<Field> entityField = ReflectionKit.CLASS_FIELD_CACHE.get(entityClass);
        if(!entityField.isEmpty() && StringUtils.hasLength(key)){
            return entityField.stream().filter(Objects::nonNull).
                    filter(field -> field.getName().equals(key)).findFirst().
                    map(u -> u.getAnnotatedType().toString()).orElse(null);
        }
        return null;
    }


    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public static void main(String[] args) {
        System.out.println(User.class.getName());
        Class<?> entityClass = ReflectionKit.CLASS_NAME_FIELD_CACHE.get(User.class.getName());
        PathBuilder entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());
        NumberPath<Integer> path = entityPath.getNumber("userType", java.lang.Integer.class);
        System.out.println(path.getClass().isInstance(NumberPath.class));
        System.out.println(path.getClass().isAssignableFrom(StringPath.class));
        System.out.println(NumberPath.class.isAssignableFrom(path.getClass()));
    }
}
