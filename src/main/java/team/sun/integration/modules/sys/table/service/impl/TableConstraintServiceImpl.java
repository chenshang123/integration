package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.TableConstraint;
import team.sun.integration.modules.sys.table.repository.TableConstraintDao;
import team.sun.integration.modules.sys.table.service.TableConstraintService;


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

    public TableConstraintServiceImpl(TableConstraintDao tableConstraintDao) {
        this.tableConstraintDao = tableConstraintDao;
    }


}
