package team.sun.integration.modules.base.tool.reflect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.Assert;
import team.sun.integration.modules.sys.user.model.entity.User;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * 反射工具类，提供反射相关的快捷操作
 *
 * @author Caratacus
 * @author hcl
 * @since 2016-09-22
 */
public final class ReflectionKit {
    private static final Log logger = LogFactory.getLog(ReflectionKit.class);

    /**
     * class field cache
     */
    private static final Map<Class<?>, List<Field>> CLASS_FIELD_CACHE = new ConcurrentHashMap<>();

    private static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_TYPE_MAP = new IdentityHashMap<>(8);

    static {
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Boolean.class, boolean.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Byte.class, byte.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Character.class, char.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Double.class, double.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Float.class, float.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Integer.class, int.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Long.class, long.class);
        PRIMITIVE_WRAPPER_TYPE_MAP.put(Short.class, short.class);
    }

    /**
     * <p>
     * 反射 method 方法名，例如 getId
     * </p>
     *
     * @param field
     * @param str   属性字符串内容
     * @deprecated 3.3.0 {@link #guessGetterName(Field, String)}
     */
    @Deprecated
    public static String getMethodCapitalize(Field field, final String str) {
        Class<?> fieldType = field.getType();
        // fix #176
        return StringUtils.guessGetterName(str, fieldType);
    }


    /**
     * <p>
     * 获取 public get方法的值
     * </p>
     *
     * @param cls    ignore
     * @param entity 实体
     * @param str    属性字符串内容
     * @return Object
     * @deprecated 3.3.2
     */
    @Deprecated
    public static Object getMethodValue(Class<?> cls, Object entity, String str) {
        Map<String, Field> fieldMaps = getFieldMap(cls);
        try {
            Method method = cls.getMethod(guessGetterName(fieldMaps.get(str), str));
            return method.invoke(entity);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Error: NoSuchMethod in %s.  Cause:", e.getCause());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error: NoSuchMethod in %s.  Cause:", e.getCause());
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Error: NoSuchMethod in %s.  Cause:", e.getCause());
        }
    }

    /**
     * 获取字段值
     *
     * @param entity    实体
     * @param fieldName 字段名称
     * @return 属性值
     */
    public static Object getFieldValue(Object entity, String fieldName) {
        Class cls = entity.getClass();
        Map<String, Field> fieldMaps = getFieldMap(cls);
        try {
            Field field = fieldMaps.get(fieldName);
            field.setAccessible(true);
            return field.get(entity);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error: NoSuchMethod in %s.  Cause:", e.getCause());
        }
    }

    /**
     * 猜测方法名
     *
     * @param field 字段
     * @param str   属性字符串内容
     * @deprecated 3.3.2
     */
    @Deprecated
    private static String guessGetterName(Field field, final String str) {
        return StringUtils.guessGetterName(str, field.getType());
    }

    /**
     * <p>
     * 获取 public get方法的值
     * </p>
     *
     * @param entity 实体
     * @param str    属性字符串内容
     * @return Object
     * @deprecated 3.3.2
     */
    @Deprecated
    public static Object getMethodValue(Object entity, String str) {
        if (null == entity) {
            return null;
        }
        return getMethodValue(entity.getClass(), entity, str);
    }


    /**
     * <p>
     * 获取该类的所有属性列表
     * </p>
     *
     * @param clazz 反射类
     */
    public static Map<String, Field> getFieldMap(Class<?> clazz) {
        List<Field> fieldList = getFieldList(clazz);

        return !fieldList.isEmpty() ? fieldList.stream().collect(Collectors.toMap(Field::getName, field -> field)) : Collections.emptyMap();
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
        if (fields.isEmpty()) {
            synchronized (CLASS_FIELD_CACHE) {
                fields = doGetFieldList(clazz);
                CLASS_FIELD_CACHE.put(clazz, fields);
            }
        }
        return fields;
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
            /* 排除重载属性 */
            Map<String, Field> fieldMap = excludeOverrideSuperField(clazz.getDeclaredFields(),
                    /* 处理父类字段 */
                    getFieldList(clazz.getSuperclass()));
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
     * 排序重置父类属性
     * </p>
     *
     * @param fields         子类属性
     * @param superFieldList 父类属性
     */
    public static Map<String, Field> excludeOverrideSuperField(Field[] fields, List<Field> superFieldList) {
        // 子类属性
        Map<String, Field> fieldMap = Stream.of(fields).collect(toMap(Field::getName, identity(),
                (u, v) -> {
                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                },
                LinkedHashMap::new));
        superFieldList.stream().filter(field -> !fieldMap.containsKey(field.getName()))
                .forEach(f -> fieldMap.put(f.getName(), f));
        return fieldMap;
    }

    /**
     * 获取字段get方法
     *
     * @param cls   class
     * @param field 字段
     * @return Get方法
     * @deprecated 3.3.2
     */
    @Deprecated
    public static Method getMethod(Class<?> cls, Field field) {
        try {
            return cls.getDeclaredMethod(ReflectionKit.guessGetterName(field, field.getName()));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Error: NoSuchMethod in %s.  Cause:", e.getCause());
        }
    }

    /**
     * 判断是否为基本类型或基本包装类型
     *
     * @param clazz class
     * @return 是否基本类型或基本包装类型
     */
    public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
        Assert.notNull(clazz, "Class must not be null");
        return (clazz.isPrimitive() || PRIMITIVE_WRAPPER_TYPE_MAP.containsKey(clazz));
    }

    /**
     * <p>
     * 反射对象获取泛型
     * </p>
     *
     * @param clazz 对象
     * @param index 泛型所在位置
     * @return Class
     */
    public static Class<?> getSuperClassGenericType(final Class<?> clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            logger.warn(String.format("Warn: %s's superclass not ParameterizedType", clazz.getSimpleName()));
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            logger.warn(String.format("Warn: Index: %s, Size of %s's Parameterized Type: %s .", index,
                    clazz.getSimpleName(), params.length));
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            logger.warn(String.format("Warn: %s not set the actual class on superclass generic parameter",
                    clazz.getSimpleName()));
            return Object.class;
        }
        return (Class<?>) params[index];
    }


    public static String baseTypeDistinguish(@NotNull String fileType) {
        Integer.class.getTypeName();
        Short.class.getTypeName();
        Long.class.getTypeName();
        Double.class.getTypeName();
        Float.class.getTypeName();
        Character.class.getTypeName();
        Byte.class.getTypeName();
        Boolean.class.getTypeName();

        BigDecimal.class.getTypeName();
        String.class.getTypeName();
        Collection.class.getTypeName();
        List.class.getTypeName();
        Set.class.getTypeName();

        if (fileType.equals("123")) {

        }
        int a = 0;
        Integer b = 1;

        return "not base type";
    }

    private static void getPValue() {

    }

    public static void main(String[] args) {
        User user = new User();
        user.setEmail("123");
        user.setGender(true);
        Field[] field = TestVo.class.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            System.out.println(field[i].getName() + "--------------" + field[i].getAnnotatedType().toString());
            if (PRIMITIVE_WRAPPER_TYPE_MAP.containsKey(field[i].getClass())) {
                System.out.println(field[i].getName() + "--------------");
                System.out.println(PRIMITIVE_WRAPPER_TYPE_MAP.get(field[i]).getTypeName());
            }
        }

    }

}
