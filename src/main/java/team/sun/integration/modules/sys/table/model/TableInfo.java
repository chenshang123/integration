package team.sun.integration.modules.sys.table.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Table(name = "sys_table")
@SQLDelete(sql = "update sys_table set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
@NamedEntityGraphs(@NamedEntityGraph(name = "Table-relation", attributeNodes = {
        @NamedAttributeNode("tableAttrs"),
        @NamedAttributeNode("tableConstraints")
}))
public class TableInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "table_id")
    private String id;

    /**
     * 一对多：表信息-表属性
     **/
    @OneToMany(mappedBy = "table", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TableAttr> tableAttrs;

    /**
     * 一对多：应用-菜单
     **/
    @OneToMany(mappedBy = "table", cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    private Set<TableConstraint> tableConstraints;

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
    private Boolean tableComment;

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

    public Boolean getTableComment() {
        return tableComment;
    }

    public void setTableComment(Boolean tableComment) {
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
