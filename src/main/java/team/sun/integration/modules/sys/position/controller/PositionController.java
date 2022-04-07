package team.sun.integration.modules.sys.position.controller;

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
import team.sun.integration.modules.sys.position.model.dto.query.PositionQueryDTO;
import team.sun.integration.modules.sys.position.model.dto.save.PositionSaveDTO;
import team.sun.integration.modules.sys.position.model.dto.update.PositionUpdateDTO;
import team.sun.integration.modules.sys.position.model.entity.Position;
import team.sun.integration.modules.sys.position.model.entity.QPosition;
import team.sun.integration.modules.sys.position.model.vo.PositionVO;
import team.sun.integration.modules.sys.position.service.PositionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-职位
 * </p>
 *
 * @author auto generator
 * @since 2021-08-11
 */
@Api(tags = "系统-职位")
@RestController
@RequestMapping("/sys/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute PositionQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QPosition qPosition = QPosition.position;
        Position entity = new Position();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qPosition.isNotNull().or(qPosition.isNull());
        PageRet pageRet = positionService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody PositionSaveDTO dto) {
        positionService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody PositionUpdateDTO dto) {
        positionService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        PositionVO vo = positionService.getPositionById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        positionService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        positionService.removeAllByIds(ids);
        return Ret.success();
    }
}