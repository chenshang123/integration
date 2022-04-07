package team.sun.integration.modules.sys.table.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;

import java.util.List;

/**
 * <p>
 * 系统-表信息
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */
@Repository
public interface TableDao extends IDao<TableInfo, String> {

    @EntityGraph("Table-relation")
    List<TableInfo> findByTableNameIn(String ...name);

}
