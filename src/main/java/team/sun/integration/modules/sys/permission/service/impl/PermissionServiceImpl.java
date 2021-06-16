package team.sun.integration.modules.sys.permission.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import team.sun.integration.modules.sys.permission.model.entity.Permission;
import team.sun.integration.modules.sys.permission.repository.PermissionDao;
import team.sun.integration.modules.sys.permission.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.sun.integration.modules.sys.resource.model.entity.Resource;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;

import java.util.*;

/**
 * <p>
 * 系统-权限表 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionDao permissionDao;
    private final ResourceDao resourceDao;

    @Autowired
    public PermissionServiceImpl(PermissionDao permissionDao, ResourceDao resourceDao) {
        this.permissionDao = permissionDao;
        this.resourceDao = resourceDao;
    }

    @Override
    public List<String> findResourceIds(List<String> permissionIds) {
        List<String> resourceIds = new ArrayList<>();
        Iterable<Permission> permissions = permissionDao.findAllById(permissionIds);
        permissions.forEach(o -> Optional.ofNullable(o.getPermissionResources()).
                ifPresent(resources -> resources.forEach(resource -> resourceIds.add(resource.getId())))
        );
        return resourceIds;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void authZResource(String permissionId, List<String> resourceIds) {
        Optional<Permission> permission = permissionDao.findById(permissionId);
        permission.ifPresent(o -> {
            permissionDao.deleteResourceMid(permissionId);
            Iterable<Resource> resources = resourceDao.findAllById(resourceIds);
            o.setPermissionResources(Sets.newHashSet(resources));
            permissionDao.save(o);
        });
    }

    @Override
    public List<Permission> getPermissionList() {
        return Lists.newArrayList(permissionDao.findAll());
    }

    @Override
    public void clearPermissionCache() {

    }
}
