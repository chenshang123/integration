package team.sun.integration.modules.sys.resource.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.resource.model.dto.save.ResourceSaveDTO;
import team.sun.integration.modules.sys.resource.model.dto.update.ResourceUpdateDTO;
import team.sun.integration.modules.sys.resource.model.entity.QResource;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;
import team.sun.integration.modules.sys.resource.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 系统-菜单： 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, Resource> implements ResourceService {

    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public ResourceServiceImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private List<Tree<String>> buildTree(List<Resource> all) {
        List<TreeNode<String>> nodeList = new ArrayList<>();
        all.forEach(item -> nodeList.add(new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getWeight())));
        //parentId 可以控制展示层级
        return TreeUtil.build(nodeList, "0");
    }

    @Override
    public List<Tree<String>> getTree(Resource query) {
        QResource resource = QResource.resource;
        Predicate predicate = resource.isNull().or(resource.isNotNull());
        predicate = query.getLayer() == null ?
                predicate : ExpressionUtils.and(predicate, resource.layer.eq(query.getLayer()));
        /*predicate = query.getApplicationResource() == null ?
                predicate : ExpressionUtils.and(predicate, resource.applicationResource.id.eq(query.getApplicationResource().getId()));*/

        JPAQuery<Resource> jpaQuery = jpaQueryFactory.selectFrom(resource).
                where(predicate);
        List<OrderSpecifier> orderSpecifierList = new ArrayList<>();
        if (query.getLayer() != null) orderSpecifierList.add(resource.layer.asc().nullsLast());
        if (query.getWeight() != null) orderSpecifierList.add(resource.weight.asc().nullsLast());
        if (orderSpecifierList.size() > 0) {
            OrderSpecifier[] orderSpecifier = orderSpecifierList.toArray(new OrderSpecifier[0]);
            jpaQuery.orderBy(orderSpecifier);
        }

        return this.buildTree(jpaQuery.fetch());
    }

    @Override
    public void clearResourceCache() {

    }

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QResource qResource = QResource.resource;
        BlazeJPAQuery<Resource> blazeJPAQuery = new BlazeJPAQuery<Resource>(entityManager, criteriaBuilderFactory)
                .from(qResource)
                .select(qResource)
                .where(predicate).orderBy(qResource.id.asc().nullsLast());
        PagedList<Resource> Resources = blazeJPAQuery.fetchPage((int)pageable.getOffset(), pageable.getPageSize());

        return new PageRet(Resources, Resources.getTotalSize());
    }

    @Override
    public Resource save(ResourceSaveDTO dto) {
        Resource entity = new Resource();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Resource update(ResourceUpdateDTO dto) {
        Optional<Resource> optional = this.getById(dto.getId());
        optional.ifPresent(Resource -> {
            BeanUtils.copyProperties(dto, Resource);
            this.dao.save(Resource);
        });
        return optional.orElse(null);
    }
}
