package team.sun.integration.modules.sys.org.controller;

import team.sun.integration.modules.sys.org.service.OrgService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统-单位/组织/机构 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-单位/组织/机构")
@RestController
@RequestMapping("/sys/org")
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO,@Valid @ModelAttribute OrgQueryDTO queryDTO){
        Org entity = new Org();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<Org> wrapper = Wrappers.lambdaQuery(entity);
        IPage<Org> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        orgService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody OrgSaveDTO dto){
        Org entity = new Org();
        BeanUtils.copyProperties(dto, entity);
        boolean state = orgService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody OrgUpdateDTO dto){
        Org entity = new Org();
        BeanUtils.copyProperties(dto, entity);
        boolean state = orgService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = Org.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        Org entity = orgService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = orgService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = orgService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}