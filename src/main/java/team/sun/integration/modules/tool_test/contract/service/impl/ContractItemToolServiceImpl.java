package team.sun.integration.modules.tool_test.contract.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractItemToolSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractItemToolUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.ContractItemTool;
import team.sun.integration.modules.tool_test.contract.model.entity.QContractItemTool;
import team.sun.integration.modules.tool_test.contract.repository.ContractItemToolDao;
import team.sun.integration.modules.tool_test.contract.service.ContractItemToolService;

import java.util.Optional;

/**
 * <p>
 * 单项明细-工器具
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class ContractItemToolServiceImpl extends ServiceImpl<ContractItemToolDao, ContractItemTool> implements ContractItemToolService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QContractItemTool qContractItemTool = QContractItemTool.contractItemTool;
        BlazeJPAQuery<ContractItemTool> blazeJPAQuery = new BlazeJPAQuery<ContractItemTool>(entityManager, criteriaBuilderFactory)
                .from(qContractItemTool)
                .select(qContractItemTool)
                .where(predicate).orderBy(qContractItemTool.id.asc().nullsLast());
        PagedList<ContractItemTool> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public ContractItemTool save(ContractItemToolSaveDTO dto) {
        ContractItemTool entity = new ContractItemTool();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public ContractItemTool update(ContractItemToolUpdateDTO dto) {
        Optional<ContractItemTool> optional = this.getById(dto.getId());
        optional.ifPresent(ContractItemTool -> {
            BeanUtils.copyProperties(dto, ContractItemTool);
            this.dao.save(ContractItemTool);
        });
        return optional.orElse(null);
    }
}
