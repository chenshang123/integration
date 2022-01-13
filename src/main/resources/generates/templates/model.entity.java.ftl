package ${config.injectionConfig.map.model}.dto.query;


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

@ApiModel(value="${entity}-query", description="查询-传参对象")
public class ${entity}QueryDTO implements Serializable{

private static final long serialVersionUID = 1L;

#foreach($field in ${table.fields})
#if(!${field.keyFlag})
@ApiModelProperty(value = "${field.comment}")
#end
private ${field.propertyType} ${field.propertyName};

#end


}