package team.sun.integration.modules.sys.table.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.table.model.entity.TableConstraint;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;
import team.sun.integration.modules.sys.table.repository.TableConstraintDao;
import team.sun.integration.modules.sys.table.service.TableConstraintService;

import java.util.ArrayList;
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
    public List<EntityRelation> getEntityRelation(Set<TableConstraint> tableConstraints) {
        if(null != tableConstraints && tableConstraints.size() > 0){
            List<EntityRelation> entityRelations = new ArrayList<>(tableConstraints.size());
            tableConstraints.forEach(tableConstraint -> {
                EntityRelation entityRelation = new EntityRelation();
                entityRelation.setConstraintName(tableConstraint.getConstraintName());
                entityRelation.setTableName(tableConstraint.getTable().getTableName());
                entityRelation.setAttrName(tableConstraint.getColumnName());
                entityRelation.setAttrNameComment(tableConstraint.getColumnComment());
                entityRelation.setReferencedTableName(tableConstraint.getReferencedTable().getTableName());
                entityRelation.setReferencedAttrName(tableConstraint.getReferencedColumnName());
                entityRelations.add(entityRelation);
            });
            return entityRelations;
        }
        return null;
    }

    @Override
    public List<EntityRelation> getActiveRelation(Set<EntityRelation> entityRelations) {
        if (null != entityRelations){
            for (EntityRelation entityRelation : entityRelations){
                entityRelation.setMaintainer(true);
                entityRelation.setType(getRelationshipType(entityRelation.getAttrNameComment()));
            }
        }
        return null;
    }

    @Override
    public List<EntityRelation> getPassiveRelation(Set<EntityRelation> entityRelations) {
        if (null != entityRelations){
            for (EntityRelation entityRelation : entityRelations){
                entityRelation.setMaintainer(getPassiveOrActiveRelation(entityRelation.getConstraintName(), entityRelation.getTableName()));
                entityRelation.setType(getRelationshipType(entityRelation.getAttrNameComment()));
            }
        }
        return null;
    }
    /** 确认关系维护方 */
    private Boolean getPassiveOrActiveRelation(String constraintName, String tableName){
        if(StringUtils.hasLength(constraintName) && StringUtils.hasLength(tableName) &&
                constraintName.startsWith(tableName)){//关系维护方
            return true;
        }else{//关系被维护方
            return false;
        }
    }

    /** 表属性对应实体关系类型 */
    private String getRelationshipType(String columnComment){
        String type = null;
        if(StringUtils.hasLength(columnComment)){
            if(columnComment.startsWith("mto")){
                type = "mto";
            }else if(columnComment.startsWith("otm")){
                type = "otm";
            }else if(columnComment.startsWith("oto")){
                type = "oto";
            }
        }
        return type;
    }

}
