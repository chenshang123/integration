package team.sun.integration.modules.sys.org.service;


import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.org.model.dto.save.OrgSaveDTO;
import team.sun.integration.modules.sys.org.model.dto.update.OrgUpdateDTO;
import team.sun.integration.modules.sys.org.model.entity.Org;

/**
 * <p>
 * 系统-单位/组织/机构 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface OrgService extends IService<Org, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Org save(OrgSaveDTO entity);

    Org update(OrgUpdateDTO entity);
}
