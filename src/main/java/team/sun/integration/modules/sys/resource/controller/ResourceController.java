package team.sun.integration.modules.sys.resource.controller;

import team.sun.integration.modules.sys.resource.service.ResourceService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO,@Valid @ModelAttribute ResourceQueryDTO queryDTO){
        Resource entity = new Resource();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<Resource> wrapper = Wrappers.lambdaQuery(entity);
        IPage<Resource> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        resourceService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ResourceSaveDTO dto){
        Resource entity = new Resource();
        BeanUtils.copyProperties(dto, entity);
        boolean state = resourceService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ResourceUpdateDTO dto){
        Resource entity = new Resource();
        BeanUtils.copyProperties(dto, entity);
        boolean state = resourceService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = Resource.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        Resource entity = resourceService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = resourceService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = resourceService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}