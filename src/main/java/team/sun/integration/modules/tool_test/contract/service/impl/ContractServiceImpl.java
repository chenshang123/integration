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
import team.sun.integration.modules.tool_test.contract.model.dto.save.ContractSaveDTO;
import team.sun.integration.modules.tool_test.contract.model.dto.update.ContractUpdateDTO;
import team.sun.integration.modules.tool_test.contract.model.entity.Contract;
import team.sun.integration.modules.tool_test.contract.model.entity.QContract;
import team.sun.integration.modules.tool_test.contract.repository.ContractDao;
import team.sun.integration.modules.tool_test.contract.service.ContractService;

import java.util.Optional;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractDao, Contract> implements ContractService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QContract qContract = QContract.contract;
        BlazeJPAQuery<Contract> blazeJPAQuery = new BlazeJPAQuery<Contract>(entityManager, criteriaBuilderFactory)
                .from(qContract)
                .select(qContract)
                .where(predicate).orderBy(qContract.id.asc().nullsLast());
        PagedList<Contract> Contracts = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(Contracts, Contracts.getTotalSize());
    }

    @Override
    public Contract save(ContractSaveDTO dto) {
        Contract entity = new Contract();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Contract update(ContractUpdateDTO dto) {
        Optional<Contract> optional = this.getById(dto.getId());
        optional.ifPresent(Contract -> {
            BeanUtils.copyProperties(dto, Contract);
            this.dao.save(Contract);
        });
        return optional.orElse(null);
    }
}
