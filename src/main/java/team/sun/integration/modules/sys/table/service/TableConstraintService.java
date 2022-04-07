package team.sun.integration.modules.sys.table.service;

import team.sun.integration.common.base.service.IService;
import team.sun.integration.modules.sys.table.model.entity.TableConstraint;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */
public interface TableConstraintService extends IService<TableConstraint, String> {
    /** 主动关系记录 **/
    List<EntityRelation> getActiveRelation(Set<TableConstraint> tableConstraints);
    /** 被动关系记录 **/
    List<EntityRelation> getPassiveRelation(Set<TableConstraint> tableConstraints);

}


