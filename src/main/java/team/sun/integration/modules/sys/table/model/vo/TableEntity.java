package team.sun.integration.modules.sys.table.model.vo;

import java.util.List;

/**
 * 表转实体对象
 */
public class TableEntity {

    /** 库名称 */
    private String tableSchema;

    /** 表名 */
    private String tableName;

    /** 表名注释 */
    private String tableComment;

    /** 外键关系表 */
    private List<EntityAttr> attrs;

    /** 属性是否允许为空 */
    private List<EntityRelation> activeRelations;

    /** 属性是否允许为空 */
    private List<EntityRelation> passiveRelations;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public List<EntityAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<EntityAttr> attrs) {
        this.attrs = attrs;
    }

    public List<EntityRelation> getActiveRelations() {
        return activeRelations;
    }

    public void setActiveRelations(List<EntityRelation> activeRelations) {
        this.activeRelations = activeRelations;
    }

    public List<EntityRelation> getPassiveRelations() {
        return passiveRelations;
    }

    public void setPassiveRelations(List<EntityRelation> passiveRelations) {
        this.passiveRelations = passiveRelations;
    }
}
