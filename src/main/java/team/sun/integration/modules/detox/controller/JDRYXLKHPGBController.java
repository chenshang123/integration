package team.sun.integration.modules.detox.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.detox.model.dto.query.JDRYXLKHPGBQueryDTO;
import team.sun.integration.modules.detox.model.dto.save.JDRYXLKHPGBSaveDTO;
import team.sun.integration.modules.detox.model.dto.update.JDRYXLKHPGBUpdateDTO;
import team.sun.integration.modules.detox.model.entity.JDRYXLKHPGB;
import team.sun.integration.modules.detox.model.entity.QJDRYXLKHPGB;
import team.sun.integration.modules.detox.model.vo.JDRYXLKHPGBVO;
import team.sun.integration.modules.detox.service.JDRYXLKHPGBService;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 戒毒-人员员训练考核评估
 * </p>
 *
 * @author auto generator
 * @since 2022-01-14
 */
@Api(tags = "戒毒-人员员训练考核评估")
@RestController
@RequestMapping("/detox/training/assess")
public class JDRYXLKHPGBController {

    private final JDRYXLKHPGBService JDRYXLKHPGBService;

    @Autowired
    public JDRYXLKHPGBController(JDRYXLKHPGBService JDRYXLKHPGBService) {
        this.JDRYXLKHPGBService = JDRYXLKHPGBService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute JDRYXLKHPGBQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QJDRYXLKHPGB qJDRYXLKHPGB = QJDRYXLKHPGB.jDRYXLKHPGB;
        JDRYXLKHPGB entity = new JDRYXLKHPGB();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qJDRYXLKHPGB.isNotNull().or(qJDRYXLKHPGB.isNull());
        PageRet pageRet = JDRYXLKHPGBService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody JDRYXLKHPGBSaveDTO dto) {
        JDRYXLKHPGBService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody JDRYXLKHPGBUpdateDTO dto) {
        JDRYXLKHPGBService.update(dto);
        return Ret.success();
    }

    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        JDRYXLKHPGBVO vo = JDRYXLKHPGBService.getVOById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        JDRYXLKHPGBService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        JDRYXLKHPGBService.removeAllByIds(ids);
        return Ret.success();
    }
}