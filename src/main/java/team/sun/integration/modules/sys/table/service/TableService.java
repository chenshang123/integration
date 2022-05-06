package team.sun.integration.modules.sys.table.service;

import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.TableEntity;

import java.util.List;

/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */
public interface TableService extends IService<TableInfo, String> {

    List<TableInfo> get(String ...tableName);

    List<TableEntity> getTableEntity(List<TableInfo> tableInfos);
}
