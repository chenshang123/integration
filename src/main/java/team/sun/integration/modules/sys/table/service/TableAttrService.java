package team.sun.integration.modules.sys.table.service;

import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.EntityAttr;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;

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

    /**
     * 多对多：表关系转实体关联关系
     */
    List<EntityRelation> getManyToMany(List<EntityRelation> tableConstraints);

    /**
     * 多对一/一对多/一对一：表关系转实体关联关系
     */
    List<EntityRelation> getOtherRelation(List<EntityAttr> entityAttrs, List<EntityRelation> tableConstraints);

}
