package team.sun.integration.modules.sys.table.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


/**
 * <p>
 * 系统-表信息：	表字段属性
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */

@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_table_attr")
@NamedEntityGraphs(@NamedEntityGraph(name = "TableAttr-relation", attributeNodes = {
        @NamedAttributeNode("table")
}))
public class TableAttr implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "table_attr_id")
    private String id;

    /**
     * 多对一： 表属性-表信息
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "table_name", referencedColumnName = "table_name", nullable = false)
    @JsonBackReference
    private TableInfo table;


    /**
     * 库名称
     */
    @Column(name = "table_schema")
    private String tableSchema;

    /**
     * 表名注解
     */
    @Column(name = "table_comment")
    private String tableComment;

    /**
     * 表限定符
     */
    @Column(name = "table_catalog")
    private String tableCatalog;

    /**
     * 列名
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 列注解
     */
    @Column(name = "column_comment")
    private String columnComment;

    /**
     * 列排序
     */
    @Column(name = "ordinal_position")
    private String ordinalPosition;

    /**
     * 列默认值
     */
    @Column(name = "column_default")
    private String columnDefault;

    /**
     * 列是否允许为空
     */
    @Column(name = "is_nullable")
    private String isNullable;

    /**
     * 列数据类型
     */
    @Column(name = "data_type")
    private String dataType;

    /**
     * 以字符为单位的最大长度
     */
    @Column(name = "character_maximum_length")
    private String characterMaximumLength;

    /**
     * 以字节为单位的最大长度
     */
    @Column(name = "character_octet_length")
    private String characterOctetLength;

    /**
     * 数字精度
     */
    @Column(name = "numeric_precision")
    private String numericPrecision;

    /**
     * 数字小数位数
     */
    @Column(name = "numeric_scale")
    private String numericScale;

    /**
     * 时间精度
     */
    @Column(name = "datetime_precision")
    private String datetimePrecision;

    /**
     * 字符集
     */
    @Column(name = "character_set_name")
    private String characterSetName;

    /**
     * 排序规则
     */
    @Column(name = "collation_name")
    private String collationName;

    @Override
    public String toString() {
        return "TableAttr{" +
                "id='" + id + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableComment=" + tableComment +
                ", tableCatalog='" + tableCatalog + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", ordinalPosition='" + ordinalPosition + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", dataType='" + dataType + '\'' +
                ", characterMaximumLength='" + characterMaximumLength + '\'' +
                ", characterOctetLength='" + characterOctetLength + '\'' +
                ", numericPrecision='" + numericPrecision + '\'' +
                ", numericScale='" + numericScale + '\'' +
                ", datetimePrecision='" + datetimePrecision + '\'' +
                ", characterSetName='" + characterSetName + '\'' +
                ", collationName='" + collationName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public TableInfo getTable() {
        return table;
    }

    public void setTable(TableInfo table) {
        this.table = table;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(String ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public String getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(String characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public String getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(String numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(String numericScale) {
        this.numericScale = numericScale;
    }

    public String getDatetimePrecision() {
        return datetimePrecision;
    }

    public void setDatetimePrecision(String datetimePrecision) {
        this.datetimePrecision = datetimePrecision;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName;
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }
}
