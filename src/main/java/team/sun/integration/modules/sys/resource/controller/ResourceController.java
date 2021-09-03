package team.sun.integration.modules.sys.resource.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.model.dto.PageDTO;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.modules.sys.resource.model.dto.query.ResourceQueryDTO;
import team.sun.integration.modules.sys.resource.model.dto.save.ResourceSaveDTO;
import team.sun.integration.modules.sys.resource.model.dto.update.ResourceUpdateDTO;
import team.sun.integration.modules.sys.resource.model.entity.QResource;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.service.ResourceService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-菜单： 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-菜单：")
@RestController
@RequestMapping("/sys/resource")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @ApiOperation(value = "树形菜单")
    @GetMapping("/tree")
    public Ret tree(@Valid @ModelAttribute ResourceQueryDTO queryDTO){
        Resource entity = new Resource();
        BeanUtils.copyProperties(queryDTO, entity);
        return Ret.success(resourceService.getTree(entity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute ResourceQueryDTO queryDTO){
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QResource qResource = QResource.resource;
        Resource entity = new Resource();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qResource.isNotNull().or(qResource.isNull());
        PageRet pageRet = resourceService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ResourceSaveDTO dto){
        resourceService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ResourceUpdateDTO dto){
        resourceService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = Resource.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id){
        Optional<Resource> entity = resourceService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        resourceService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        resourceService.removeAllByIds(ids);
        return Ret.success();
    }
}