package team.sun.integration.modules.tool_test.contract.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractItemToolSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractItemToolUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.ContractItemTool;

/**
 * <p>
 * 单项明细-工器具
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface ContractItemToolService extends IService<ContractItemTool, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);
    ContractItemTool save(ContractItemToolSaveDTO entity);
    ContractItemTool update(ContractItemToolUpdateDTO entity);
}
