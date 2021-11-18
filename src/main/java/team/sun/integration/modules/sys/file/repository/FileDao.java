package team.sun.integration.modules.sys.file.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import team.sun.integration.modules.base.repository.IDao;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;

import java.util.List;
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
public interface FileDao extends IDao<FileEntity, String> {

    @Override
    @EntityGraph("-relation")
    Optional<FileEntity> findById(String id);

    List<FileEntity> findByBusinessId(String businessId);

    FileEntity findByName(String name);
}
