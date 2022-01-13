package team.sun.integration.modules.sys.config.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.config.model.dto.query.SecurityParamQueryDTO;
import team.sun.integration.modules.sys.config.model.dto.save.SecurityParamSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.SecurityParamUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.QSecurityParam;
import team.sun.integration.modules.sys.config.model.entity.SecurityParam;
import team.sun.integration.modules.sys.config.service.SecurityParamService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
public class SecurityParamController {

    private final SecurityParamService securityParamService;

    @Autowired
    public SecurityParamController(SecurityParamService securityParamService) {
        this.securityParamService = securityParamService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute SecurityParamQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QSecurityParam qSecurityParam = QSecurityParam.securityParam;
        SecurityParam entity = new SecurityParam();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qSecurityParam.isNotNull().or(qSecurityParam.isNull());
        PageRet pageRet = securityParamService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody SecurityParamSaveDTO dto) {
        securityParamService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody SecurityParamUpdateDTO dto) {
        securityParamService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<SecurityParam> entity = securityParamService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        securityParamService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        securityParamService.removeAllByIds(ids);
        return Ret.success();
    }
}