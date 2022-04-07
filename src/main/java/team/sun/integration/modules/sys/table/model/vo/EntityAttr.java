package team.sun.integration.modules.sys.table.model.vo;

/**
 * 表数据集合
 */
public class EntityAttr {

    /** 属性名（驼峰命名）*/
    private String humpName;

    /** Java属性类型 */
    private String dataType;

    /** 属性默认值 */
    private String attrDefault;

    /** 属性说明 */
    private String comment;

    /** 以字符为单位的最大长度 */
    private String characterMaximumLength;

    /** 属性是否允许为空 */
    private String isNullable;

    public String getHumpName() {
        return humpName;
    }

    public void setHumpName(String humpName) {
        this.humpName = humpName;
    }

    public String getAttrDefault() {
        return attrDefault;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setAttrDefault(String attrDefault) {
        this.attrDefault = attrDefault;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }
}
