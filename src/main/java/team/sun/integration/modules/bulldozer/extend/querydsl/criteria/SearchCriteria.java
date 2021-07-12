package team.sun.integration.modules.bulldozer.extend.querydsl.criteria;

/**
 * 搜索条件
 */
public class SearchCriteria {

    /**对象名称*/
    private String tableName;
    /**属性名称*/
    private String key;
    /**操作类型*/
    private String operation;
    /**传入参数*/
    private String[] values;

    public SearchCriteria(String tableName, String key, String operation, String[] values) {
        this.tableName = tableName;
        this.key = key;
        this.operation = operation;
        this.values = values;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
