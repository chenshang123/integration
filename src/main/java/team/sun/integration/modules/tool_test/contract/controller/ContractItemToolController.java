package team.sun.integration.modules.tool_test.contract.controller;

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
import team.sun.integration.modules.tool_test.contract.model.dto.query.ContractItemToolQueryDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractItemToolSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractItemToolUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.ContractItemTool;
import team.sun.integration.modules.tool_test.contract.model.entity.QContractItemTool;
import team.sun.integration.modules.tool_test.contract.service.ContractItemToolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 合同-单项明细-工器具
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Api(tags = "合同-单项明细-工器具")
@RestController
@RequestMapping("/sys/contractItemTool")
public class ContractItemToolController {

    private final ContractItemToolService contractItemToolService;

    @Autowired
    public ContractItemToolController(ContractItemToolService contractItemToolService) {
        this.contractItemToolService = contractItemToolService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute ContractItemToolQueryDTO queryDTO){
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QContractItemTool qContractItemTool = QContractItemTool.contractItemTool;
        ContractItemTool entity = new ContractItemTool();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qContractItemTool.isNotNull().or(qContractItemTool.isNull());
        PageRet pageRet = contractItemToolService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ContractItemToolSaveDTO dto){
        contractItemToolService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ContractItemToolUpdateDTO dto){
        contractItemToolService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = ContractItemTool.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id){
        Optional<ContractItemTool> entity = contractItemToolService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        contractItemToolService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        contractItemToolService.removeAllByIds(ids);
        return Ret.success();
    }
}