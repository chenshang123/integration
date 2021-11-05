package team.sun.integration.modules.sys.permission.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.google.common.collect.Lists;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.permission.model.dto.save.PermissionDataSaveDTO;
import team.sun.integration.modules.sys.permission.model.dto.update.PermissionDataUpdateDTO;
import team.sun.integration.modules.sys.permission.model.entity.PermissionData;
import team.sun.integration.modules.sys.permission.model.entity.QPermissionData;
import team.sun.integration.modules.sys.permission.repository.PermissionDataDao;
import team.sun.integration.modules.sys.permission.service.PermissionDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sun.integration.modules.sys.resource.repository.ResourceDao;

import java.util.*;

/**
 * <p>
 * 系统-数据权限 服务实现类
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Service
public class PermissionDataServiceImpl extends ServiceImpl<PermissionDataDao, PermissionData> implements PermissionDataService {

    private final PermissionDataDao permissionDataDao;

    @Autowired
    public PermissionDataServiceImpl(PermissionDataDao permissionDataDao, ResourceDao resourceDao) {
        this.permissionDataDao = permissionDataDao;
    }

    @Override
    public List<PermissionData> getPermissionList() {
        return Lists.newArrayList(permissionDataDao.findAll());
    }

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QPermissionData qPermissionData = QPermissionData.permissionData;
        BlazeJPAQuery<PermissionData> blazeJPAQuery = new BlazeJPAQuery<PermissionData>(entityManager, criteriaBuilderFactory)
                .from(qPermissionData)
                .select(qPermissionData)
                .where(predicate).orderBy(qPermissionData.id.asc().nullsLast());
        PagedList<PermissionData> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public PermissionData save(PermissionDataSaveDTO dto) {
        PermissionData entity = new PermissionData();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public PermissionData update(PermissionDataUpdateDTO dto) {
        Optional<PermissionData> optional = this.getById(dto.getId());
        optional.ifPresent(PermissionData -> {
            BeanUtils.copyProperties(dto, PermissionData);
            this.dao.save(PermissionData);
        });
        return optional.orElse(null);
    }
}
