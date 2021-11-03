package team.sun.integration.modules.sys.file.repository;

import org.springframework.stereotype.Repository;
import team.sun.integration.config.base.repository.IDao;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.vo.FileVO;

import java.util.List;

/**
 * <p>
 * 系统-应用
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Repository
public interface FileDao extends IDao<FileEntity, String> {

    List<FileEntity> findByBusinessId(String businessId);

    FileEntity findByName(String name);
}
