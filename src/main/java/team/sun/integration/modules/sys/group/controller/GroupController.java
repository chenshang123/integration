package team.sun.integration.modules.sys.group.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.group.model.dto.query.GroupQueryDTO;
import team.sun.integration.modules.sys.group.model.dto.save.GroupSaveDTO;
import team.sun.integration.modules.sys.group.model.dto.update.GroupUpdateDTO;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.group.model.entity.QGroup;
import team.sun.integration.modules.sys.group.model.vo.GroupVO;
import team.sun.integration.modules.sys.group.service.GroupService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute GroupQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QGroup qGroup = QGroup.group;
        Group entity = new Group();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qGroup.isNotNull().or(qGroup.isNull());
        PageRet pageRet = groupService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody GroupSaveDTO dto) {
        groupService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody GroupUpdateDTO dto) {
        groupService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        GroupVO vo = groupService.getGroupById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        groupService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        groupService.removeAllByIds(ids);
        return Ret.success();
    }
}