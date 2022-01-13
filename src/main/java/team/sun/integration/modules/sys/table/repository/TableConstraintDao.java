package team.sun.integration.modules.sys.table.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.table.model.entity.TableConstraint;

import java.util.Optional;

/**
 * <p>
 * 系统-表关系
 * </p>
 *
 * @author auto generator
 * @since 2021-11-30
 */
@Repository
public interface TableConstraintDao extends IDao<TableConstraint, String> {

    @Override
    @EntityGraph("TableConstraint-relation")
    @NotNull
    Optional<TableConstraint> findById(@NotNull String id);
}
