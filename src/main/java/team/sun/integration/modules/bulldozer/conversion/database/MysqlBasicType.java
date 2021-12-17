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
public class MysqlBasicType {

    public static  final Map<String, String> basicTypes = new HashMap<>(20);

    static {
        basicTypes.put("tinyint", java.lang.Integer.class.getTypeName());
        basicTypes.put("smallint", java.lang.Integer.class.getTypeName());
        basicTypes.put("mediumint", java.lang.Integer.class.getTypeName());
        basicTypes.put("integer", java.lang.Integer.class.getTypeName());
        basicTypes.put("bigint", java.lang.Long.class.getTypeName());
        basicTypes.put("float", java.lang.Float.class.getTypeName());
        basicTypes.put("double", java.lang.Double.class.getTypeName());
        basicTypes.put("decimal", java.math.BigDecimal.class.getTypeName());
        basicTypes.put("date", java.sql.Date.class.getTypeName());
        basicTypes.put("datetime", java.sql.Timestamp.class.getTypeName());
        basicTypes.put("timestamp", java.sql.Timestamp.class.getTypeName());
        basicTypes.put("time", java.sql.Time.class.getTypeName());
        basicTypes.put("char", java.lang.String.class.getTypeName());//java.lang.String(除非该列字符集设置为 BINARY，那样返回 byte[])
        basicTypes.put("varchar", java.lang.String.class.getTypeName());
        basicTypes.put("binary", java.lang.Byte.class.getTypeName());
        basicTypes.put("varbinary", java.lang.Byte.class.getTypeName());
        basicTypes.put("tinyblob", java.lang.Byte.class.getTypeName());
        basicTypes.put("blob", java.lang.Byte.class.getTypeName());
        basicTypes.put("mediumblob", java.lang.Byte.class.getTypeName());
        basicTypes.put("longblob", java.lang.Byte.class.getTypeName());
    }


}
