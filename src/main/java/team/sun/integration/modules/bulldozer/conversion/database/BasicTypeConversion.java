package team.sun.integration.modules.bulldozer.conversion.database;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 数据库基本类型转换
 * </p>
 *
 * @author chens
 * @since 2021-11-30
 */
public class BasicTypeConversion {

    public static final Map<String, String> MysqlAndJava = new HashMap<>(20);

    static {
        MysqlAndJava.put("int", java.lang.Integer.class.getSimpleName());
        MysqlAndJava.put("tinyint", java.lang.Integer.class.getSimpleName());
        MysqlAndJava.put("smallint", java.lang.Integer.class.getSimpleName());
        MysqlAndJava.put("mediumint", java.lang.Integer.class.getSimpleName());
        MysqlAndJava.put("integer", java.lang.Integer.class.getSimpleName());
        MysqlAndJava.put("bigint", java.lang.Long.class.getSimpleName());
        MysqlAndJava.put("float", java.lang.Float.class.getSimpleName());
        MysqlAndJava.put("double", java.lang.Double.class.getSimpleName());
        MysqlAndJava.put("decimal", java.math.BigDecimal.class.getSimpleName());
        MysqlAndJava.put("date", java.sql.Date.class.getSimpleName());
        MysqlAndJava.put("datetime", java.sql.Timestamp.class.getSimpleName());
        MysqlAndJava.put("timestamp", java.sql.Timestamp.class.getSimpleName());
        MysqlAndJava.put("time", java.sql.Time.class.getSimpleName());
        MysqlAndJava.put("char", java.lang.String.class.getSimpleName());//java.lang.String(除非该列字符集设置为 BINARY，那样返回 byte[])
        MysqlAndJava.put("varchar", java.lang.String.class.getSimpleName());
        MysqlAndJava.put("binary", java.lang.Byte.class.getSimpleName());
        MysqlAndJava.put("varbinary", java.lang.Byte.class.getSimpleName());
        MysqlAndJava.put("tinyblob", java.lang.Byte.class.getSimpleName());
        MysqlAndJava.put("blob", java.lang.Byte.class.getSimpleName());
        MysqlAndJava.put("mediumblob", java.lang.Byte.class.getSimpleName());
        MysqlAndJava.put("longblob", java.lang.Byte.class.getSimpleName());
    }


}
