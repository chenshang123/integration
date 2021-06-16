package team.sun.integration.modules.sys.group.controller;

import team.sun.integration.modules.sys.group.service.GroupService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */
@Api(tags = "系统-用户组：	组具有自己的角色信息、权限信息")
@RestController
@RequestMapping("/sys/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO,@Valid @ModelAttribute GroupQueryDTO queryDTO){
        Group entity = new Group();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<Group> wrapper = Wrappers.lambdaQuery(entity);
        IPage<Group> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        groupService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody GroupSaveDTO dto){
        Group entity = new Group();
        BeanUtils.copyProperties(dto, entity);
        boolean state = groupService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody GroupUpdateDTO dto){
        Group entity = new Group();
        BeanUtils.copyProperties(dto, entity);
        boolean state = groupService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = Group.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        Group entity = groupService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = groupService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = groupService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}