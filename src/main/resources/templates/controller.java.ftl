package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${config.injectionConfig.map.parent}.base.model.dto.PageDTO;
import ${config.injectionConfig.map.parent}.base.model.vo.Ret;
import ${config.injectionConfig.map.parent}.base.enums.ret.BusRetEnum;
import ${config.injectionConfig.map.model}.dto.save.${entity}SaveDTO;
import ${config.injectionConfig.map.model}.dto.update.${entity}UpdateDTO;
import ${config.injectionConfig.map.model}.dto.query.${entity}QueryDTO;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

import io.swagger.annotations.*;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* <p>
    * ${table.comment} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Api(tags = "${table.comment}")
@RestController
@RequestMapping("/${config.injectionConfig.map.moduleName}#if(${config.injectionConfig.map.functionName}!=${table.entityPath})/${config.injectionConfig.map.functionName}#end/${table.entityPath}")
public class ${table.controllerName} {

@Autowired
private ${entity}Service ${table.entityPath}Service;

@ApiOperation(value = "分页查询")
@GetMapping("/page")
public Ret page(PageDTO pageDTO, ${entity}QueryDTO queryDTO){
${entity} entity = new ${entity}();
BeanUtils.copyProperties(queryDTO, entity);
Wrapper<${entity}> wrapper = Wrappers.lambdaQuery(entity);
IPage<${entity}> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
${table.entityPath}Service.page(page, wrapper);
return Ret.success(page);
}


@ApiOperation(value = "保存")
@PostMapping("/save")
public Ret save(@Valid @RequestBody ${entity}SaveDTO dto){
${entity} entity = new ${entity}();
BeanUtils.copyProperties(dto, entity);
boolean state = ${table.entityPath}Service.save(entity);
return Ret.successOrFail(state);
}

@ApiOperation(value = "修改")
@PostMapping("/update")
public Ret update(@Valid @RequestBody ${entity}UpdateDTO dto){
${entity} entity = new ${entity}();
BeanUtils.copyProperties(dto, entity);
boolean state = ${table.entityPath}Service.updateById(entity);
return Ret.successOrFail(state);
}


@ApiOperation(value = "详情", response = ${entity}.class)
@GetMapping("/dtl")
public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
${entity} entity = ${table.entityPath}Service.getById(id);
if(null == entity){
return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
}
return Ret.success(entity);
}

@ApiOperation(value = "单个删除")
@PostMapping("/delete")
public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
boolean state = ${table.entityPath}Service.removeById(id);
return Ret.successOrFail(state);
}

@ApiOperation(value = "批量删除")
@PostMapping("/batchDelete")
public Ret batchDelete(@RequestBody List
<Long> ids) {
    boolean state = ${table.entityPath}Service.removeByIds(ids);
    return Ret.successOrFail(state);
    }
    }