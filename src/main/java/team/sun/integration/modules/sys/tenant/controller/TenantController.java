package team.sun.integration.modules.sys.tenant.controller;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.modules.base.model.dto.PageDTO;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.model.vo.Ret;
import team.sun.integration.modules.sys.tenant.model.dto.query.TenantQueryDTO;
import team.sun.integration.modules.sys.tenant.model.dto.save.TenantSaveDTO;
import team.sun.integration.modules.sys.tenant.model.dto.update.TenantUpdateDTO;
import team.sun.integration.modules.sys.tenant.model.entity.QTenant;
import team.sun.integration.modules.sys.tenant.model.entity.QTenantApplication;
import team.sun.integration.modules.sys.tenant.model.entity.Tenant;
import team.sun.integration.modules.sys.tenant.model.vo.TenantVO;
import team.sun.integration.modules.sys.tenant.service.TenantApplicationService;
import team.sun.integration.modules.sys.tenant.service.TenantService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统-租户
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Api(tags = "系统-租户")
@RestController
@RequestMapping("/sys/tenant")
public class TenantController {

    private final TenantService tenantService;

    private final TenantApplicationService tenantApplicationService;

    @Autowired
    public TenantController(TenantService tenantService, TenantApplicationService tenantApplicationService) {
        this.tenantService = tenantService;
        this.tenantApplicationService = tenantApplicationService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute TenantQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QTenant qTenant = QTenant.tenant;
        Tenant entity = new Tenant();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qTenant.isNotNull().or(qTenant.isNull());
        predicate = queryDTO.getApplication_id() == null ?
                predicate : ExpressionUtils.and(predicate, qTenant.tenantApplications.any().application.id.eq(queryDTO.getApplication_id()));

        PageRet pageRet = tenantService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }

    @ApiOperation(value = "租户-应用列表")
    @GetMapping("/applications")
    public Ret applications(@ApiParam(name = "tenant_id", value = "tenant_id", required = true) @RequestParam String tenant_id) {
        QTenantApplication qTenantApplication = QTenantApplication.tenantApplication;
        Predicate predicate = qTenantApplication.isNotNull().or(qTenantApplication.isNull());
        predicate = !StringUtils.hasLength(tenant_id) ?
                predicate : ExpressionUtils.and(predicate, qTenantApplication.tenant.id.eq(tenant_id));

        return Ret.success(tenantApplicationService.getApplication(predicate));
    }

    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody TenantSaveDTO dto) {
        tenantService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody TenantUpdateDTO dto) {
        tenantService.update(dto);
        return Ret.success();
    }

    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        TenantVO vo = tenantService.getTenantById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        tenantService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        tenantService.removeAllByIds(ids);
        return Ret.success();
    }
}