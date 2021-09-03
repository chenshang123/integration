package team.sun.integration.modules.sys.resource.service;

import cn.hutool.core.lang.tree.Tree;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.resource.model.dto.save.ResourceSaveDTO;
import team.sun.integration.modules.sys.resource.model.dto.update.ResourceUpdateDTO;
import team.sun.integration.modules.sys.resource.model.entity.Resource;

import java.util.List;

/**
 * <p>
 * 系统-菜单： 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
public interface ResourceService extends IService<Resource, String> {

    List<Tree<String>> getTree(Resource query);

    void clearResourceCache();

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);
    Resource save(ResourceSaveDTO entity);
    Resource update(ResourceUpdateDTO entity);
}
