package team.sun.integration.modules.sys.role.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.role.model.dto.query.RoleQueryDTO;
import team.sun.integration.modules.sys.role.model.dto.save.RoleSaveDTO;
import team.sun.integration.modules.sys.role.model.dto.update.RoleUpdateDTO;
import team.sun.integration.modules.sys.role.model.entity.QRole;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;
import team.sun.integration.modules.sys.role.service.RoleService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute RoleQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QRole qRole = QRole.role;
        Role entity = new Role();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qRole.isNotNull().or(qRole.isNull());
        PageRet pageRet = roleService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody RoleSaveDTO dto) {
        roleService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody RoleUpdateDTO dto) {
        roleService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        RoleVO vo = roleService.getRoleById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<Role> entity = roleService.getById(id);
        entity.ifPresent(roleService::remove);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        Iterable<Role> entities = roleService.getByIds(ids);
        roleService.removeByIds(IterableUtils.toList(entities));
        return Ret.success();
    }
}