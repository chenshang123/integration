package team.sun.integration.modules.sys.role.service.impl;

import team.sun.integration.modules.sys.role.service.RolePermissionMidService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 中间表：角色-权限 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class RolePermissionMidServiceImpl implements RolePermissionMidService {

    /*@Override
    public List<String> findPermissionByRoleIds(List<String> roleIds) {
        RolePermissionMid entity = new RolePermissionMid();
        Wrapper<RolePermissionMid> wrapper = Wrappers.lambdaQuery(entity)
                .in(RolePermissionMid::getRoleId, roleIds);
        List<RolePermissionMid> lst = this.list(wrapper);
        List<String> permissions = new ArrayList<>();
        for (RolePermissionMid item : lst) {
            if(null != item.getPermissionId()){
                permissions.add(item.getPermissionId());
            }
        }
        return permissions;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void authZ(String roleId, List<String> permissionIds) {
        //先删除roleId所有的权限
        RolePermissionMid query = new RolePermissionMid();
        query.setRoleId(roleId);
        this.remove(Wrappers.lambdaQuery(query));
        // 然后再添加
        RolePermissionMid entity = null;
        List<RolePermissionMid> addLst = new ArrayList<>();
        for(String item : permissionIds){
            entity = new RolePermissionMid();
            entity.setRoleId(roleId);
            entity.setPermissionId(item);
            addLst.add(entity);
        }
        if(addLst.size()>0){
            this.saveBatch(addLst);
        }
    }*/
}
