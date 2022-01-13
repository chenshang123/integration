package team.sun.integration.modules.sys.org.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.common.base.repository.IDao;
import team.sun.integration.modules.sys.org.model.entity.Org;

import java.util.Optional;

/**
 * <p>
 * 系统-单位/组织/机构 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Repository
public interface OrgDao extends IDao<Org, String> {

    @Override
    @EntityGraph("Org-relation")
    @NotNull
    Optional<Org> findById(@NotNull String Id);
}
