package team.sun.integration.modules.sys.config.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.config.model.dto.save.CodeValueSaveDTO;
import team.sun.integration.modules.sys.config.model.dto.update.CodeValueUpdateDTO;
import team.sun.integration.modules.sys.config.model.entity.CodeValue;
import team.sun.integration.modules.sys.config.model.entity.QCodeValue;
import team.sun.integration.modules.sys.config.repository.CodeValueDao;
import team.sun.integration.modules.sys.config.service.CodeValueService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 系统-码值 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
@Service
public class CodeValueServiceImpl extends ServiceImpl<CodeValueDao, CodeValue> implements CodeValueService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QCodeValue qCodeValue = QCodeValue.codeValue;
        BlazeJPAQuery<CodeValue> blazeJPAQuery = new BlazeJPAQuery<CodeValue>(entityManager, criteriaBuilderFactory)
                .from(qCodeValue)
                .select(qCodeValue)
                .where(predicate).orderBy(qCodeValue.id.asc().nullsLast());
        PagedList<CodeValue> codeValues = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(codeValues, codeValues.getTotalSize());
    }

    @Override
    public CodeValue save(CodeValueSaveDTO dto) {
        CodeValue entity = new CodeValue();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public CodeValue update(CodeValueUpdateDTO dto) {
        Optional<CodeValue> optional = this.getById(dto.getId());
        optional.ifPresent(CodeValue -> {
            BeanUtils.copyProperties(dto, CodeValue);
            this.dao.save(CodeValue);
        });
        return optional.orElse(null);
    }
}
