package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.entity.TableConstraint;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;
import team.sun.integration.modules.sys.table.repository.TableConstraintDao;
import team.sun.integration.modules.sys.table.service.TableConstraintService;

import java.util.List;
import java.util.Set;


/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-12-14
 */
@Service
public class TableConstraintServiceImpl extends ServiceImpl<TableConstraintDao, TableConstraint> implements TableConstraintService {

    private final TableConstraintDao tableConstraintDao;

    @Autowired
    public TableConstraintServiceImpl(TableConstraintDao tableConstraintDao) {
        this.tableConstraintDao = tableConstraintDao;
    }


    @Override
    public List<EntityRelation> getActiveRelation(Set<TableConstraint> tableConstraints) {
        return null;
    }

    @Override
    public List<EntityRelation> getPassiveRelation(Set<TableConstraint> tableConstraints) {
        return null;
    }
}
