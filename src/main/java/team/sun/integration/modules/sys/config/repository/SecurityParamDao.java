package team.sun.integration.modules.sys.config.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.config.model.entity.SecurityParam;

import java.util.Optional;

/**
 * <p>
 * 系统-参数配置 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-02-24
 */
@Repository
public interface SecurityParamDao extends IDao<SecurityParam, String> {

    @Override
    @EntityGraph("SecurityParam-relation")
    Optional<SecurityParam> findById(String id);
}
