package team.sun.integration.modules.sys.role.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;
import team.sun.integration.modules.sys.role.model.dto.save.RoleSaveDTO;
import team.sun.integration.modules.sys.role.model.dto.update.RoleUpdateDTO;
import team.sun.integration.modules.sys.role.model.entity.QRole;
import team.sun.integration.modules.sys.role.model.entity.Role;
import team.sun.integration.modules.sys.role.model.vo.RoleVO;
import team.sun.integration.modules.sys.role.repository.RoleDao;
import team.sun.integration.modules.sys.role.service.RoleService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * <p>
 * 系统-角色：	角色关联单位 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    private final RoleDao roleDao;
    private final ResourceDao resourceDao;

    public RoleServiceImpl(RoleDao roleDao, ResourceDao resourceDao) {
        this.roleDao = roleDao;
        this.resourceDao = resourceDao;
    }

    @Override
    public void authZ(String roleId, List<String> resourceIds) {
        Optional<Role> role = roleDao.findById(roleId);
        role.ifPresent(o -> {
            //删除: 多对多关系-角色资源权限
            o.getResources().clear();
            //添加: 多对多关系-角色资源权限
            Iterable<Resource> resources = resourceDao.findAllById(resourceIds);
            o.setResources(Sets.newHashSet(resources));
            roleDao.save(o);
        });
    }

    @Override
    public List<Role> getRoleList() {
        return Lists.newArrayList(roleDao.findAll());
    }

    @Override
    public List<String> findResourceIds(List<String> roleIds) {
        List<String> resourceIds = new ArrayList<>();
        Iterable<Role> roles = roleDao.findAllById(roleIds);
        roles.forEach(role -> role.getResources().
                forEach(resource -> resourceIds.add(resource.getId())));
        return resourceIds;
    }

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QRole qRole = QRole.role;
        BlazeJPAQuery<Role> blazeJPAQuery = new BlazeJPAQuery<Role>(entityManager, criteriaBuilderFactory)
                .from(qRole)
                .select(qRole)
                .where(predicate).orderBy(qRole.id.asc().nullsLast());
        PagedList<Role> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public Role save(RoleSaveDTO dto) {
        Role entity = new Role();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Role update(RoleUpdateDTO dto) {
        Optional<Role> optional = this.getById(dto.getId());
        optional.ifPresent(role -> {
            BeanUtils.copyProperties(dto, role);
            this.dao.save(role);
        });
        return optional.orElse(null);
    }

    @Override
    public RoleVO getRoleById(String id) {
        Optional<Role> optional = this.dao.findById(id);
        RoleVO vo = new RoleVO();
        optional.ifPresent(role -> BeanUtils.copyProperties(role, vo));
        return vo;
    }
}
