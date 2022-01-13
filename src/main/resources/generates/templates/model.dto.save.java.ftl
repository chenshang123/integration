package ${config.injectionConfig.map.model}.dto.save;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.io.Serializable;
import java.time.LocalDateTime;
/**
* <p>
    * ${table.comment}
    * </p>
*
* @author ${author}
* @since ${date}
*/

@Data
@ApiModel(value="${entity}-save", description="修改-保存对象")
public class ${entity}SaveDTO implements Serializable{

private static final long serialVersionUID = 1L;

#foreach($field in ${table.fields})
#if(!${field.keyFlag})
@ApiModelProperty(value = "${field.comment}")
#end
private ${field.propertyType} ${field.propertyName};

#end
}