package team.sun.integration.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切面日志注解
 *
 * @author TaoYu
 */
@Target(ElementType.METHOD)
/*          TYPE,				 类、接口（包括注释类型）或枚举声明
            FIELD,				 字段声明（包括枚举常量）
            METHOD,				 方法声明
            PARAMETER,	 		 形式参数声明
            CONSTRUCTOR,		 构造方法声明
            LOCAL_VARIABLE,		 局部变量声明
            ANNOTATION_TYPE,	 注释类型声明
            PACKAGE,			 包声明
            TYPE_PARAMETER,		 类型参数声明 @since 1.8
            TYPE_USE			 任何类型声明 @since 1.8
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface BusinessLog {

    /**
     * 操作
     */
    String value();

    /**
     * 日志类型0：系统日志，1：业务日志，2：异常事件警告
     *
     * @return
     */
    int type() default 0;

    /**
     * 异常事件等级
     *
     * @return
     */
    String exceLevel() default "";

}
