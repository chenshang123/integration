package team.sun.integration.modules.sys.file.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.file.model.dto.save.FileSaveDTO;
import team.sun.integration.modules.sys.file.model.dto.update.FileUpdateDTO;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-文件
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface FileService extends IService<FileEntity, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    List<FileEntity> getByBusinessId(String businessId);

    FileEntity save(FileSaveDTO entity);

    FileEntity update(FileUpdateDTO entity);

    Ret upload(HttpServletRequest request);
}
