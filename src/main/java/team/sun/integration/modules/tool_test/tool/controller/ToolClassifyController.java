package team.sun.integration.modules.tool_test.tool.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.model.dto.PageDTO;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.modules.tool_test.tool.model.dto.query.ToolClassifyQueryDTO;
import team.sun.integration.modules.tool_test.tool.model.dto.save.ToolClassifySaveDTO;
import team.sun.integration.modules.tool_test.tool.model.dto.update.ToolClassifyUpdateDTO;
import team.sun.integration.modules.tool_test.tool.model.entity.QToolClassify;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;
import team.sun.integration.modules.tool_test.tool.service.ToolClassifyService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 工器具-分类
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Api(tags = "工器具-分类")
@RestController
@RequestMapping("/sys/toolClassify")
public class ToolClassifyController {

    private final ToolClassifyService toolClassifyService;

    @Autowired
    public ToolClassifyController(ToolClassifyService toolClassifyService) {
        this.toolClassifyService = toolClassifyService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute ToolClassifyQueryDTO queryDTO){
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QToolClassify qToolClassify = QToolClassify.toolClassify;
        ToolClassify entity = new ToolClassify();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qToolClassify.isNotNull().or(qToolClassify.isNull());
        PageRet pageRet = toolClassifyService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ToolClassifySaveDTO dto){
        toolClassifyService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ToolClassifyUpdateDTO dto){
        toolClassifyService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = ToolClassify.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id){
        Optional<ToolClassify> entity = toolClassifyService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        toolClassifyService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        toolClassifyService.removeAllByIds(ids);
        return Ret.success();
    }
}