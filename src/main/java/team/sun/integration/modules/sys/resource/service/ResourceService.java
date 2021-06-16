package team.sun.integration.modules.sys.resource.service;

import cn.hutool.core.lang.tree.Tree;
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
public interface ResourceService {

    List<Tree<String>> getTree(List<String> permissionIds);

    List<Tree<String>> getTree(Resource query);

    void clearResourceCache();
}
