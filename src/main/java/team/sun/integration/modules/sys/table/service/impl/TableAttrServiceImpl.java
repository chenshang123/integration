package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.stereotype.Service;
import team.sun.integration.modules.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.TableAttr;
import team.sun.integration.modules.sys.table.repository.TableAttrDao;
import team.sun.integration.modules.sys.table.service.TableAttrService;


/**
 * <p>
 * 系统-表信息：表字段属性
 * </p>
 *
 * @author auto generator
 * @since 2021-12-14
 */
@Service
public class TableAttrServiceImpl extends ServiceImpl<TableAttrDao, TableAttr> implements TableAttrService {

    private final TableAttrDao tableAttrDao;

    public TableAttrServiceImpl(TableAttrDao tableAttrDao) {
        this.tableAttrDao = tableAttrDao;
    }


}
