package team.sun.integration.modules.bulldozer.extend.querydsl;

import cn.hutool.core.util.ArrayUtil;
import org.reflections8.Reflections;
import org.reflections8.scanners.TypeAnnotationsScanner;
import org.springframework.util.NumberUtils;
import team.sun.integration.common.base.tool.reflect.TestVo;
import team.sun.integration.modules.sys.user.model.entity.User;

import javax.persistence.Table;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ReflectionTable {
    /**
     * 基本-包装类型
     */
    public static final List<String> PRIMITIVE_AND_WRAPPER_TYPE_LIST;
    public static final Map<String, Class<?>> CLASS_NAME_FIELD_CACHE;
    public static final Map<Class<?>, List<Field>> CLASS_FIELD_CACHE = new ConcurrentHashMap<>();
    /**
     * class field cache
     */
    private static final String packageName = "team.sun.integration.modules";

    static {
        Reflections reflections = new Reflections(packageName, new TypeAnnotationsScanner());
        Set<Class<?>> ENTITY_SET = reflections.getTypesAnnotatedWith(Table.class, true);
        CLASS_NAME_FIELD_CACHE = new HashMap<>(ENTITY_SET.size());
        ENTITY_SET.stream().filter(Objects::nonNull).forEach(o -> {
            CLASS_NAME_FIELD_CACHE.put(o.getName(), o);
            CLASS_FIELD_CACHE.put(o, ReflectionTable.getFieldList(o));

        });

        PRIMITIVE_AND_WRAPPER_TYPE_LIST = new ArrayList<>(23);
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(0, java.lang.Integer.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(1, int.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(2, java.lang.Short.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(3, short.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(4, java.lang.Long.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(5, long.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(6, java.lang.Double.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(7, double.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(8, java.lang.Float.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(9, float.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(10, java.lang.Character.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(11, char.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(12, java.lang.Byte.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(13, byte.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(14, java.lang.Boolean.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(15, boolean.class.getTypeName());

        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(16, java.math.BigDecimal.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(17, java.lang.String.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(18, java.util.Collection.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(19, java.util.List.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(20, java.util.Set.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(21, java.time.LocalDateTime.class.getTypeName());
        PRIMITIVE_AND_WRAPPER_TYPE_LIST.add(22, java.util.Date.class.getTypeName());
    }

    /**
     * <p>
     * 获取该类的所有属性列表
     * </p>
     *
     * @param clazz 反射类
     */
    public static List<Field> doGetFieldList(Class<?> clazz) {
        if (clazz.getSuperclass() != null) {
            // 子类属性
            Map<String, Field> fieldMap = Stream.of(clazz.getDeclaredFields()).collect(toMap(Field::getName, identity(),
                    (u, v) -> {
                        throw new IllegalStateException(String.format("Duplicate key %s", u));
                    },
                    LinkedHashMap::new));
            /*
             * 重写父类属性过滤后处理忽略部分，支持过滤父类属性功能
             * 场景：中间表不需要记录创建时间，忽略父类 createTime 公共属性
             * 中间表实体重写父类属性 ` private transient Date createTime; `
             */
            return fieldMap.values().stream()
                    /* 过滤静态属性 */
                    .filter(f -> !Modifier.isStatic(f.getModifiers()))
                    /* 过滤 transient关键字修饰的属性 */
                    .filter(f -> !Modifier.isTransient(f.getModifiers()))
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * <p>
     * 获取该类的所有属性列表
     * </p>
     *
     * @param clazz 反射类
     */
    public static List<Field> getFieldList(Class<?> clazz) {
        if (Objects.isNull(clazz)) {
            return Collections.emptyList();
        }
        List<Field> fields = CLASS_FIELD_CACHE.get(clazz);
        if (fields == null || fields.isEmpty()) {
            synchronized (CLASS_FIELD_CACHE) {
                fields = doGetFieldList(clazz);
                CLASS_FIELD_CACHE.put(clazz, fields);
            }
        }
        return fields;
    }

    /**
     * 判断是否为基本类型或基本包装类型
     *
     * @param field field
     * @return 是否基本类型或基本包装类型
     */
    public static boolean isPrimitiveOrWrapper(Field field) {
        for (String s : PRIMITIVE_AND_WRAPPER_TYPE_LIST) {
            if (field.getAnnotatedType().toString().contains(s)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 字符串数组转其他类型数组
     */
    public static <T extends Number> T[] parseNumber(String[] values, Class<T> targetClass) {
        if (!ArrayUtil.isEmpty(values) && null != targetClass) {
            T[] result = (T[]) Array.newInstance(targetClass, values.length);
            for (int i = 0; i < values.length; i++) {
                result[i] = NumberUtils.parseNumber("123", targetClass);
            }
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("123");
        TestVo testVo = new TestVo();
        testVo.setBaseInteger(1);
        CLASS_FIELD_CACHE.get(user.getClass()).forEach(o ->
                System.out.println(o.getName() + "-------------" + o.getAnnotatedType() + "---------------" + ReflectionTable.isPrimitiveOrWrapper(o))
        );

    }


}
