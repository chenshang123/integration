package team.sun.integration.modules.tool_test.contract.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.Contract;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface ContractService extends IService<Contract, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);
    Contract save(ContractSaveDTO entity);
    Contract update(ContractUpdateDTO entity);
}
