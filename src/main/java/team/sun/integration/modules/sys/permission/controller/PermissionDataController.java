package team.sun.integration.modules.sys.permission.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.permission.model.dto.query.PermissionDataQueryDTO;
import team.sun.integration.modules.sys.permission.model.dto.save.PermissionDataSaveDTO;
import team.sun.integration.modules.sys.permission.model.dto.update.PermissionDataUpdateDTO;
import team.sun.integration.modules.sys.permission.model.entity.PermissionData;
import team.sun.integration.modules.sys.permission.model.entity.QPermissionData;
import team.sun.integration.modules.sys.permission.service.PermissionDataService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-权限表 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-数据权限")
@RestController
@RequestMapping("/sys/permissionData")
public class PermissionDataController {

    private final PermissionDataService permissionDataService;

    @Autowired
    public PermissionDataController(PermissionDataService permissionDataService) {
        this.permissionDataService = permissionDataService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute PermissionDataQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QPermissionData qPermissionData = QPermissionData.permissionData;
        PermissionData entity = new PermissionData();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qPermissionData.isNotNull().or(qPermissionData.isNull());
        PageRet pageRet = permissionDataService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody PermissionDataSaveDTO dto) {
        permissionDataService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody PermissionDataUpdateDTO dto) {
        permissionDataService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<PermissionData> entity = permissionDataService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        permissionDataService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        permissionDataService.removeAllByIds(ids);
        return Ret.success();
    }
}