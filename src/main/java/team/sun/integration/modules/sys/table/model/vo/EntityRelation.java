package team.sun.integration.modules.sys.table.model.vo;

/**
 * 表转实体对象: 关联关系集合
 * 2022-02-21
 */
public class EntityRelation {

    /**关系类型（一对一、一对多、多对一、多对多）*/
    private String type;

    /**关系维护方*/
    private boolean maintainer;

    /** 关联关系名称 */
    private String constraintName;

    /** 主表名 */
    private String tableName;

    /** 主表关联字段 */
    private String attrName;

    /** 主表关联字段注解说明 */
    private String attrNameComment;

    /** 外键关系表 */
    private String referencedTableName;

    /** 外键关系表字段 */
    private String referencedAttrName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMaintainer() {
        return maintainer;
    }

    public void setMaintainer(boolean maintainer) {
        this.maintainer = maintainer;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrNameComment() {
        return attrNameComment;
    }

    public void setAttrNameComment(String attrNameComment) {
        this.attrNameComment = attrNameComment;
    }

    public String getReferencedTableName() {
        return referencedTableName;
    }

    public void setReferencedTableName(String referencedTableName) {
        this.referencedTableName = referencedTableName;
    }

    public String getReferencedAttrName() {
        return referencedAttrName;
    }

    public void setReferencedAttrName(String referencedAttrName) {
        this.referencedAttrName = referencedAttrName;
    }
}
