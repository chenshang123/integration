package team.sun.integration.modules.sys.table.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


/**
 * <p>
 * 系统-表信息： 表关联关系
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */

@Entity
@Table(name = "sys_table_constraint")
@SQLDelete(sql = "update sys_table_constraint set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "TableConstraint-relation", attributeNodes = {
        @NamedAttributeNode("org")
}))
public class TableConstraint implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "table_constraint_id")
    private String id;

    /**
     * 约束关系所在库名称
     */
    @Column(name = "constraint_schema")
    private String constraintSchema;

    /**
     * 外键名称
     */
    @Column(name = "constraint_name")
    private String constraintName;

    /**
     * 主表所在库名称
     */
    @Column(name = "table_schema")
    private Boolean tableSchema;

    /**
     * 主表名称
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 多对一： 表关系-表信息
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "table_name", referencedColumnName = "table_name", nullable = false)
    @JsonBackReference
    private TableInfo table;


    /**
     * 主表约束字段名称
     */
    @Column(name = "column_name")
    private String columnName;

    /**
     * 关联表库名
     */
    @Column(name = "referenced_table_schema")
    private String referencedTableSchema;

    /**
     * 关联表表名
     */
    @Column(name = "referenced_table_name")
    private String referencedTableName;

    /**
     * 关联表字段名
     */
    @Column(name = "referenced_column_name")
    private String referencedColumnName;

    @Override
    public String toString() {
        return "TableConstraint{" +
                "id='" + id + '\'' +
                ", constraintSchema='" + constraintSchema + '\'' +
                ", constraintName='" + constraintName + '\'' +
                ", tableSchema=" + tableSchema +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", referencedTableSchema='" + referencedTableSchema + '\'' +
                ", referencedTableName='" + referencedTableName + '\'' +
                ", referencedColumnName='" + referencedColumnName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstraintSchema() {
        return constraintSchema;
    }

    public void setConstraintSchema(String constraintSchema) {
        this.constraintSchema = constraintSchema;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public Boolean getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(Boolean tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getReferencedTableSchema() {
        return referencedTableSchema;
    }

    public void setReferencedTableSchema(String referencedTableSchema) {
        this.referencedTableSchema = referencedTableSchema;
    }

    public String getReferencedTableName() {
        return referencedTableName;
    }

    public void setReferencedTableName(String referencedTableName) {
        this.referencedTableName = referencedTableName;
    }

    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName;
    }
}
