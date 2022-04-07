package team.sun.integration.modules.detox.controller;

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
import team.sun.integration.modules.detox.model.dto.query.JDRYTZCSJLBQueryDTO;
import team.sun.integration.modules.detox.model.dto.save.JDRYTZCSJLBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYTZCSJLBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYTZCSJLB;
import team.sun.integration.modules.detox.model.entity.QJDRYTZCSJLB;
import team.sun.integration.modules.detox.model.vo.JDRYTZCSJLBVO;
import team.sun.integration.modules.detox.service.JDRYTZCSJLBService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 戒毒-人员体质测试
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Api(tags = "戒毒-人员体质测试")
@RestController
@RequestMapping("/detox/physical/test")
public class JDRYTZCSJLBController {

    private final JDRYTZCSJLBService JDRYTZCSJLBService;

    @Autowired
    public JDRYTZCSJLBController(JDRYTZCSJLBService JDRYTZCSJLBService) {
        this.JDRYTZCSJLBService = JDRYTZCSJLBService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute JDRYTZCSJLBQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QJDRYTZCSJLB qJDRYTZCSJLB = QJDRYTZCSJLB.jDRYTZCSJLB;
        JDRYTZCSJLB entity = new JDRYTZCSJLB();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qJDRYTZCSJLB.isNotNull().or(qJDRYTZCSJLB.isNull());
        PageRet pageRet = JDRYTZCSJLBService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody JDRYTZCSJLBSaveDTO dto) {
        JDRYTZCSJLBService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody JDRYTZCSJLBUpdateDTO dto) {
        JDRYTZCSJLBService.update(dto);
        return Ret.success();
    }

    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        JDRYTZCSJLBVO vo = JDRYTZCSJLBService.getVOById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        JDRYTZCSJLBService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        JDRYTZCSJLBService.removeAllByIds(ids);
        return Ret.success();
    }
}