package team.sun.integration.modules.sys.application.controller;

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
import team.sun.integration.modules.sys.application.model.dto.query.ApplicationQueryDTO;
import team.sun.integration.modules.sys.application.model.dto.save.ApplicationSaveDTO;
import team.sun.integration.modules.sys.application.model.dto.update.ApplicationUpdateDTO;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.sys.application.model.entity.QApplication;
import team.sun.integration.modules.sys.application.model.vo.ApplicationVO;
import team.sun.integration.modules.sys.application.service.ApplicationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Api(tags = "系统-应用")
@RestController
@RequestMapping("/sys/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute ApplicationQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QApplication qApplication = QApplication.application;
        Application entity = new Application();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qApplication.isNotNull().or(qApplication.isNull());
        PageRet pageRet = applicationService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ApplicationSaveDTO dto) {
        applicationService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ApplicationUpdateDTO dto) {
        applicationService.update(dto);
        return Ret.success();
    }

    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        ApplicationVO vo = applicationService.getApplicationById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        applicationService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        applicationService.removeAllByIds(ids);
        return Ret.success();
    }
}