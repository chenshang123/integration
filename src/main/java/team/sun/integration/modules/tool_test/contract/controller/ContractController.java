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
import team.sun.integration.modules.tool_test.contract.model.dto.query.ContractQueryDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.Contract;
import team.sun.integration.modules.tool_test.contract.model.entity.QContract;
import team.sun.integration.modules.tool_test.contract.service.ContractService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 合同
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Api(tags = "合同")
@RestController
@RequestMapping("/sys/contract")
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute ContractQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QContract qContract = QContract.contract;
        Contract entity = new Contract();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qContract.isNotNull().or(qContract.isNull());
        PageRet pageRet = contractService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody ContractSaveDTO dto) {
        contractService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody ContractUpdateDTO dto) {
        contractService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = Contract.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<Contract> entity = contractService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        contractService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        contractService.removeAllByIds(ids);
        return Ret.success();
    }
}