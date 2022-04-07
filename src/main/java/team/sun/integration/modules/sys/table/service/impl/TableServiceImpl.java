package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.stereotype.Service;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.repository.TableDao;
import team.sun.integration.modules.sys.table.service.TableService;

import java.util.List;


/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-12-14
 */
@Service
public class TableServiceImpl extends ServiceImpl<TableDao, TableInfo> implements TableService {

    @Override
    public List<TableInfo> get(String ...tableNameLike) {
        return this.dao.findByTableNameIn(tableNameLike);
    }

}
