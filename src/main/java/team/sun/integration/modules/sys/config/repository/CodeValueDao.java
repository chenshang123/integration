package team.sun.integration.modules.sys.config.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.config.model.entity.CodeValue;
import team.sun.integration.modules.sys.config.model.vo.CodeValueVO;

import java.util.List;

/**
 * <p>
 * 系统-码值 Mapper 接口
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
@Repository
public interface CodeValueDao extends IDao<CodeValue, String> {

    /**
     * 数据库视图查询
     *
     * @param viewName 查询对象
     * @return k，v
     */
    @Query(value = "SELECT id,`name`,parent_id parentId FROM ?1", nativeQuery = true)
    List<CodeValueVO> selectView(String viewName);

}
