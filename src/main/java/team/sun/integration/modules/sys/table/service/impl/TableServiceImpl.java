package team.sun.integration.modules.sys.table.service.impl;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.EntityAttr;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;
import team.sun.integration.modules.sys.table.model.vo.TableEntity;
import team.sun.integration.modules.sys.table.repository.TableDao;
import team.sun.integration.modules.sys.table.service.TableAttrService;
import team.sun.integration.modules.sys.table.service.TableConstraintService;
import team.sun.integration.modules.sys.table.service.TableService;

import java.util.ArrayList;
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

    private final TableConstraintService tableConstraintService;

    private final TableAttrService tableAttrService;

    @Autowired
    public TableServiceImpl(TableConstraintService tableConstraintService, TableAttrService tableAttrService) {
        this.tableConstraintService = tableConstraintService;
        this.tableAttrService = tableAttrService;
    }

    @Override
    public List<TableInfo> get(String ...tableNameLike) {
        return this.dao.findByTableNameIn(tableNameLike);
    }

    @Override
    public List<TableEntity> getTableEntity(List<TableInfo> tableInfoList) {
        TableEntity tableEntity = new TableEntity();
        List<TableEntity> tableEntities = new ArrayList<>(tableInfoList.size());
        //属性循环
        for (TableInfo tableInfo : tableInfoList) {
            List<EntityAttr> attrs = tableAttrService.getEntityAttr(tableInfo);
            //主动关系
            List<EntityRelation> activeRelations = tableConstraintService.getEntityRelation(tableInfo.getTableConstraints());
            //被动关系
            List<EntityRelation> passiveRelations = tableConstraintService.getEntityRelation(tableInfo.getReferencedTableConstraints());
            //设置基本信息
            tableEntity.setTableSchema(tableInfo.getTableSchema());
            tableEntity.setTableName(tableInfo.getTableName());
            tableEntity.setClassName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableInfo.getTableName()));
            tableEntity.setTableComment(tableInfo.getTableComment());
            tableEntity.setAttrs(attrs);
            tableEntity.setActiveRelations(activeRelations);
            tableEntity.setPassiveRelations(passiveRelations);

            tableEntities.add(tableEntity);
            tableEntity = new TableEntity();
        }
        return tableEntities;
    }


}
