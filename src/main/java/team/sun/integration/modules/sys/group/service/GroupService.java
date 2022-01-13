package team.sun.integration.modules.sys.group.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.group.model.dto.save.GroupSaveDTO;
import team.sun.integration.modules.sys.group.model.dto.update.GroupUpdateDTO;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.group.model.vo.GroupVO;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息 服务类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */
public interface GroupService extends IService<Group, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    Group save(GroupSaveDTO dto);

    Group update(GroupUpdateDTO dto);

    GroupVO getGroupById(String id);
}
