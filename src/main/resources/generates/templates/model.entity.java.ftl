package ${packagePath}.entity.dto.query;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.time.LocalDateTime;
/**
* <p>
    * ${entity.tableComment}
    * </p>
*
* @author 代码生成
* @since ${entity.createTime}
*/

@ApiModel(value="${entity.className}-entity", description="实体-对象")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "${entity.tableName}")
@SQLDelete(sql = "update sys_user set del_flag = true where id = ? and version = ? ")
@Where(clause = "del_flag = false")
public class ${entity.className} implements Serializable{

private static final long serialVersionUID = 1L;
<#if (entity.attrs)??>
    <#list entity.attrs as field>

        @ApiModelProperty(value = "${field.comment!''}")
        <#if field.name == 'creator_id'>
        @CreatedBy
        <#elseif field.name == 'create_time'>
        @CreatedDate
        <#elseif field.name == 'modifier_id'>
        @LastModifiedBy
        <#elseif field.name == 'update_time'>
        @LastModifiedDate
        <#elseif field.name == 'version'>
        @Version
        </#if>
        <#if (field.name)??>@Column(name = "${field.name}")</#if>
        private ${field.dataType!''} ${field.lowerCamelName!''}<#if (field.atrtDefault)??> = ${field.atrtDefault}</#if>;
    </#list>
</#if>

<#if (entity.attrs)??>
    <#list entity.attrs as attr>
        <#if (attr.name)??>
        public String get${attr.lowerCamelName}() { return ${attr.lowerCamelName}; }

        public void set${attr.lowerCamelName}(String id) { this.${attr.lowerCamelName} = ${attr.lowerCamelName}; }

        </#if>
    </#list>
</#if>
}