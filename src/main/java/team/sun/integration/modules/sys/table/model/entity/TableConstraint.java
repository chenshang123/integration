package team.sun.integration.modules.sys.table.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_table_constraint")
@NamedEntityGraphs(@NamedEntityGraph(name = "TableConstraint-relation", attributeNodes = {
        @NamedAttributeNode("table"),
        @NamedAttributeNode("referencedTable")
}))
public class TableConstraint implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "table_constraint_id")
    private String id;

    /**
     * 多对一： 表关系-表信息
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "table_name", referencedColumnName = "table_name", nullable = false)
    @JsonBackReference
    private TableInfo table;

    /**
     * 关联表表名
     */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "referenced_table_name", referencedColumnName = "table_name", nullable = false)
    @JsonBackReference
    private TableInfo referencedTable;

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
    private String tableSchema;

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
                ", tableSchema='" + tableSchema + '\'' +
                ", columnName='" + columnName + '\'' +
                ", referencedTableSchema='" + referencedTableSchema + '\'' +
                ", referencedColumnName='" + referencedColumnName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TableInfo getTable() {
        return table;
    }

    public void setTable(TableInfo table) {
        this.table = table;
    }

    public TableInfo getReferencedTable() {
        return referencedTable;
    }

    public void setReferencedTable(TableInfo referencedTable) {
        this.referencedTable = referencedTable;
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

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
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

    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName;
    }
}
