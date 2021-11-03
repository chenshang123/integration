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
import team.sun.integration.modules.sys.file.model.vo.FileVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    List<FileVO> get(String businessId);

    List<String> getNames(String businessId);

    String getPath(String name);

    FileEntity save(FileSaveDTO entity);

    FileEntity update(FileUpdateDTO entity);

    Ret upload(HttpServletRequest request);

    void downloadLocalImg(HttpServletResponse response, String name);
}
