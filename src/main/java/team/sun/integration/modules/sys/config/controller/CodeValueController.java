package team.sun.integration.modules.sys.config.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.modules.base.enums.ret.BusRetEnum;
import team.sun.integration.modules.base.model.dto.PageDTO;
import team.sun.integration.modules.base.model.vo.PageRet;
import team.sun.integration.modules.base.model.vo.Ret;
import team.sun.integration.modules.sys.config.model.dto.query.CodeValueQueryDTO;
import team.sun.integration.modules.sys.config.model.dto.save.CodeValueSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.CodeValueUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.CodeValue;
import team.sun.integration.modules.sys.config.model.entity.QCodeValue;
import team.sun.integration.modules.sys.config.service.CodeValueService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-码值 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
@Api(tags = "系统-码值")
@RestController
@RequestMapping("/sys/config/codeValue")
public class CodeValueController {

    private final CodeValueService codeValueService;

    @Autowired
    public CodeValueController(CodeValueService codeValueService) {
        this.codeValueService = codeValueService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute CodeValueQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QCodeValue qCodeValue = QCodeValue.codeValue;
        CodeValue entity = new CodeValue();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qCodeValue.isNotNull().or(qCodeValue.isNull());
        PageRet pageRet = codeValueService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody CodeValueSaveDTO dto) {
        codeValueService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody CodeValueUpdateDTO dto) {
        codeValueService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<CodeValue> entity = codeValueService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        codeValueService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        codeValueService.removeAllByIds(ids);
        return Ret.success();
    }

}