package team.sun.integration.modules.sys.table.service;

import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.EntityAttr;

import java.util.List;

/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */
public interface TableAttrService extends IService<TableAttr, String> {

    TableAttr getUserById(String id);

    /**
     * 表对象转实体属性
     */
    List<EntityAttr> getEntityAttr(TableInfo tableInfo);

}
