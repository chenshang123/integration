package team.sun.integration.modules.sys.region.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.region.model.dto.save.RegionSaveDTO;
import team.sun.integration.modules.sys.region.model.dto.update.RegionUpdateDTO;
import team.sun.integration.modules.sys.region.model.entity.Region;

/**
 * <p>
 * 系统-行政区域
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface RegionService extends IService<Region, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Region save(RegionSaveDTO entity);

    Region update(RegionUpdateDTO entity);
}
