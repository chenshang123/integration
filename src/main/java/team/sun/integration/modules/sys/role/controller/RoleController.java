package team.sun.integration.modules.sys.role.controller;

import team.sun.integration.modules.sys.role.service.RoleService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统-角色：	角色关联单位 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-角色：	角色关联单位")
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO,@Valid @ModelAttribute RoleQueryDTO queryDTO){
        Role entity = new Role();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<Role> wrapper = Wrappers.lambdaQuery(entity);
        IPage<Role> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        roleService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody RoleSaveDTO dto){
        Role entity = new Role();
        BeanUtils.copyProperties(dto, entity);
        boolean state = roleService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody RoleUpdateDTO dto){
        Role entity = new Role();
        BeanUtils.copyProperties(dto, entity);
        boolean state = roleService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = Role.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        Role entity = roleService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = roleService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = roleService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}