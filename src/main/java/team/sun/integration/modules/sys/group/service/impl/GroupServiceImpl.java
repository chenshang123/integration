package team.sun.integration.modules.sys.group.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.group.model.dto.save.GroupSaveDTO;
import team.sun.integration.modules.sys.group.model.dto.update.GroupUpdateDTO;
import team.sun.integration.modules.sys.group.model.entity.Group;
import team.sun.integration.modules.sys.group.model.entity.QGroup;
import team.sun.integration.modules.sys.group.model.vo.GroupVO;
import team.sun.integration.modules.sys.group.repository.GroupDao;
import team.sun.integration.modules.sys.group.service.GroupService;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.sys.permission.model.entity.PermissionData;

import java.util.Optional;

/**
 * <p>
 * 系统-用户组：	组具有自己的角色信息、权限信息 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-01
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupDao, Group> implements GroupService {


    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QGroup qGroup = QGroup.group;
        BlazeJPAQuery<Group> blazeJPAQuery = new BlazeJPAQuery<Group>(entityManager, criteriaBuilderFactory)
                .from(qGroup)
                .select(qGroup)
                .where(predicate).orderBy(qGroup.id.asc().nullsLast());
        PagedList<Group> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public Group save(GroupSaveDTO dto) {
        Group entity = new Group();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public Group update(GroupUpdateDTO dto) {
        Optional<Group> optional = this.getById(dto.getId());
        optional.ifPresent(Group -> {
            BeanUtils.copyProperties(dto, Group);
            this.dao.save(Group);
        });
        return optional.orElse(null);
    }

    @Override
    public GroupVO getGroupById(String id) {
        Optional<Group> optional = this.dao.findById(id);
        GroupVO vo = new GroupVO();
        optional.ifPresent(entity -> BeanUtils.copyProperties(entity, vo));
        return vo;
    }
}
