package team.sun.integration.modules.sys.org.controller;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.org.model.dto.query.OrgQueryDTO;
import team.sun.integration.modules.sys.org.model.dto.save.OrgSaveDTO;
import team.sun.integration.modules.sys.org.model.dto.update.OrgUpdateDTO;
import team.sun.integration.modules.sys.org.model.entity.Org;
import team.sun.integration.modules.sys.org.model.entity.QOrg;
import team.sun.integration.modules.sys.org.model.vo.OrgVO;
import team.sun.integration.modules.sys.org.service.OrgService;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 系统-单位/组织/机构 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-单位/组织/机构")
@RestController
@RequestMapping("/sys/org")
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute OrgQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QOrg qOrg = QOrg.org;
        Org entity = new Org();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qOrg.isNotNull().or(qOrg.isNull());
        PageRet pageRet = orgService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody OrgSaveDTO dto) {
        orgService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody OrgUpdateDTO dto) {
        orgService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情")
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        OrgVO vo = orgService.getOrgById(id);
        return Ret.success(vo);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        orgService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        orgService.removeAllByIds(ids);
        return Ret.success();
    }
}