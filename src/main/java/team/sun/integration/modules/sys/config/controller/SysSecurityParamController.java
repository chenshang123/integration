package team.sun.integration.modules.sys.config.controller;

import team.sun.integration.modules.sys.config.service.SysSecurityParamService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统-参数配置 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */
@Api(tags = "系统-参数配置")
@RestController
@RequestMapping("/sys/config/sysSecurityParam")
public class SysSecurityParamController {

    private final SysSecurityParamService sysSecurityParamService;

    @Autowired
    public SysSecurityParamController(SysSecurityParamService sysSecurityParamService) {
        this.sysSecurityParamService = sysSecurityParamService;
    }

    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, SysSecurityParamQueryDTO queryDTO){
        SysSecurityParam entity = new SysSecurityParam();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<SysSecurityParam> wrapper = Wrappers.lambdaQuery(entity);
        IPage<SysSecurityParam> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        sysSecurityParamService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody SysSecurityParamSaveDTO dto){
        SysSecurityParam entity = new SysSecurityParam();
        BeanUtils.copyProperties(dto, entity);
        boolean state = sysSecurityParamService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody SysSecurityParamUpdateDTO dto){
        SysSecurityParam entity = new SysSecurityParam();
        BeanUtils.copyProperties(dto, entity);
        boolean state = sysSecurityParamService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = SysSecurityParam.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        SysSecurityParam entity = sysSecurityParamService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = sysSecurityParamService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = sysSecurityParamService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}