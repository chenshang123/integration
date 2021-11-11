package team.sun.integration.modules.tool_test.contract.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.tool_test.contract.model.entity.Contract;

import java.util.Optional;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface ContractDao extends IDao<Contract, String> {

    @Override
    @EntityGraph("Contract-relation")
    @NotNull
    Optional<Contract> findById(@NotNull String id);
}
