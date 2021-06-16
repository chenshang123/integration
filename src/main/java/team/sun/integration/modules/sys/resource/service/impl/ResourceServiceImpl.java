package team.sun.integration.modules.sys.resource.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import team.sun.integration.modules.sys.permission.model.entity.Permission;
import team.sun.integration.modules.sys.permission.repository.PermissionDao;
import team.sun.integration.modules.sys.resource.model.entity.QResource;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;
import team.sun.integration.modules.sys.resource.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统-菜单： 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceDao resourceDao;
    private final PermissionDao permissionDao;
    private final JPAQueryFactory jpaQueryFactory;

    @Autowired
    public ResourceServiceImpl(ResourceDao resourceDao, PermissionDao permissionDao,
                               JPAQueryFactory jpaQueryFactory) {
        this.resourceDao = resourceDao;
        this.permissionDao = permissionDao;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private List<Tree<String>> buildTree(List<Resource> all) {
        List<TreeNode<String>> nodeList = new ArrayList<>();
        all.forEach(item -> nodeList.add(new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getSort())));
        //parentId 可以控制展示层级
        return TreeUtil.build(nodeList, "0");
    }

    @Override
    public List<Tree<String>> getTree(List<String> permissionIds) {
        List<Resource> lst = new ArrayList<>();
        Iterable<Permission> permissions = permissionDao.findAllById(permissionIds);
        permissions.forEach(permission -> lst.addAll(permission.getPermissionResources()));
        return this.buildTree(lst);
    }

    @Override
    public List<Tree<String>> getTree(Resource query) {
        QResource resource = QResource.resource;
        Predicate predicate = resource.isNull().or(resource.isNull());
        predicate = resource.layer == null ?
                predicate : ExpressionUtils.and(predicate, resource.layer.eq(query.getLayer()));

        JPAQuery<Resource> jpaQuery = jpaQueryFactory.selectFrom(resource).
                where(predicate);
        List<OrderSpecifier> orderSpecifierList = new ArrayList<>();
        if (query.getLayer() != null) orderSpecifierList.add(resource.layer.asc().nullsLast());
        if (query.getSort() != null) orderSpecifierList.add(resource.sort.asc().nullsLast());
        if (orderSpecifierList.size() > 0) {
            OrderSpecifier[] orderSpecifier = orderSpecifierList.toArray(new OrderSpecifier[orderSpecifierList.size()]);
            jpaQuery.orderBy(orderSpecifier);
        }

        return this.buildTree(jpaQuery.fetch());
    }

    @Override
    public void clearResourceCache() {

    }

}
