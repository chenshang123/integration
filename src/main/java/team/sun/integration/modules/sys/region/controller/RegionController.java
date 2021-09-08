package team.sun.integration.modules.sys.region.controller;

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
import team.sun.integration.modules.sys.region.model.dto.query.RegionQueryDTO;
import team.sun.integration.modules.sys.region.model.dto.save.RegionSaveDTO;
import team.sun.integration.modules.sys.region.model.dto.update.RegionUpdateDTO;
import team.sun.integration.modules.sys.region.model.entity.QRegion;
import team.sun.integration.modules.sys.region.model.entity.Region;
import team.sun.integration.modules.sys.region.service.RegionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-行政区域
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Api(tags = "系统-行政区域")
@RestController
@RequestMapping("/sys/region")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute RegionQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QRegion qRegion = QRegion.region;
        Region entity = new Region();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qRegion.isNotNull().or(qRegion.isNull());
        PageRet pageRet = regionService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody RegionSaveDTO dto) {
        regionService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody RegionUpdateDTO dto) {
        regionService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = Region.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<Region> entity = regionService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        regionService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        regionService.removeAllByIds(ids);
        return Ret.success();
    }
}