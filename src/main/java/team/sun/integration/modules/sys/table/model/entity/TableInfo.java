package team.sun.integration.modules.sys.table.model.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;


/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */

@Entity
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sys_table")
@NamedEntityGraphs(@NamedEntityGraph(name = "Table-relation", attributeNodes = {
        @NamedAttributeNode("tableAttrs"),
        @NamedAttributeNode("tableConstraints"),
        @NamedAttributeNode("referencedTableConstraints")
}))
public class TableInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "table_id")
    private String id;

    /**
     * 一对多：表关系-单表关联
     **/
    @OneToMany(mappedBy = "table", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @OrderBy
    private Set<TableAttr> tableAttrs;

    /**
     * 一对多：表信息-表关系
     **/
    @OneToMany(mappedBy = "table", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TableConstraint> tableConstraints;

    /**
     * 一对多：表关系-中间表关联
     **/
    @OneToMany(mappedBy = "referencedTable", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TableConstraint> referencedTableConstraints;

    /**
     * 库名称
     */
    @Column(name = "table_schema")
    private String tableSchema;

    /**
     * 表名
     */
    @Column(name = "table_name")
    private String tableName;

    /**
     * 表名注释
     */
    @Column(name = "table_comment")
    private String tableComment;

    /**
     * 编码集
     */
    @Column(name = "table_collation")
    private String tableCollation;

    /**
     * 表类型（BASE TABLE、VIEW）
     */
    @Column(name = "table_type")
    private String tableType;

    /**
     * 数据库引擎
     */
    @Column(name = "engine")
    private String engine;

    /**
     * 版本
     */
    @Column(name = "version")
    private String version;

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", tableComment=" + tableComment +
                ", tableCollation='" + tableCollation + '\'' +
                ", tableType='" + tableType + '\'' +
                ", engine='" + engine + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<TableAttr> getTableAttrs() {
        return tableAttrs;
    }

    public void setTableAttrs(Set<TableAttr> tableAttrs) {
        this.tableAttrs = tableAttrs;
    }

    public Set<TableConstraint> getTableConstraints() {
        return tableConstraints;
    }

    public void setTableConstraints(Set<TableConstraint> tableConstraints) {
        this.tableConstraints = tableConstraints;
    }

    public Set<TableConstraint> getReferencedTableConstraints() {
        return referencedTableConstraints;
    }

    public void setReferencedTableConstraints(Set<TableConstraint> referencedTableConstraints) {
        this.referencedTableConstraints = referencedTableConstraints;
    }

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

    public String getTableCollation() {
        return tableCollation;
    }

    public void setTableCollation(String tableCollation) {
        this.tableCollation = tableCollation;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
