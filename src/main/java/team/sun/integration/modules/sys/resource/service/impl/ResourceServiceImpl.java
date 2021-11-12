package team.sun.integration.modules.sys.resource.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.google.common.collect.Lists;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.resource.model.dto.save.ResourceSaveDTO;
import team.sun.integration.modules.sys.resource.model.dto.update.ResourceUpdateDTO;
import team.sun.integration.modules.sys.resource.model.entity.QResource;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.model.vo.ResourceVO;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;
import team.sun.integration.modules.sys.resource.service.ResourceService;

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

    private List<Tree<String>> buildTree(List<Resource> all, String parentId) {
        //parentId 可以控制展示层级,默认展示所有
        if(!StringUtils.hasLength(parentId)){
            parentId = "0";
        }
        if(null != all && !all.isEmpty()){
            List<TreeNode<String>> nodeList = new ArrayList<>(all.size());
            all.forEach(item -> nodeList.add(new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getWeight())));
            return TreeUtil.build(nodeList, parentId);
        }
        return null;
    }
    private List<Tree<String>> buildTree(List<Resource> all) {
        //parentId 可以控制展示层级,默认展示所有
        if(null != all && !all.isEmpty()){
            List<TreeNode<String>> nodeList = new ArrayList<>(all.size());
            all.forEach(item -> nodeList.add(new TreeNode<>(item.getId(), item.getParentId(), item.getName(), item.getWeight())));
            return TreeUtil.build(nodeList, "0");
        }
        return null;
    }

    @Override
    public List<Tree<String>> getTree(Predicate predicate) {
        QResource resource = QResource.resource;

        OrderSpecifier[] orderSpecifiers = {resource.layer.asc().nullsLast(), resource.weight.asc().nullsLast()};
        Iterable<Resource> resourceIterable = this.get(predicate, orderSpecifiers);
        return this.buildTree(Lists.newArrayList(resourceIterable));
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
        PagedList<Resource> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
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

    @Override
    public ResourceVO getResourceById(String id) {
        Optional<Resource> optional = this.dao.findById(id);
        ResourceVO vo = new ResourceVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }

    public static void main(String[] args) {
        List<Resource> all = null;
        all.forEach(item -> item.getWeight());
    }
}
