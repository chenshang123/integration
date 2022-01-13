package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
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

    @Autowired
    public TableAttrServiceImpl(TableAttrDao tableAttrDao) {
        this.tableAttrDao = tableAttrDao;
    }


    @Override
    public TableAttr getUserById(String id) {
        return this.tableAttrDao.findById(id).get();
    }
}
