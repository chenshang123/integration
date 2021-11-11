package team.sun.integration.modules.tool_test.tool.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;

import java.util.Optional;

/**
 * <p>
 * 工器具-分类
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface ToolClassifyDao extends IDao<ToolClassify, String> {

    @Override
    @EntityGraph("ToolClassify-relation")
    Optional<ToolClassify> findById(String id);
}
