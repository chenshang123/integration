package team.sun.integration.modules.sys.file.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.file.model.dto.save.FileSaveDTO;
import team.sun.integration.modules.sys.file.model.dto.update.FileUpdateDTO;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.entity.QFileEntity;
import team.sun.integration.modules.sys.file.repository.FileDao;
import team.sun.integration.modules.sys.file.service.FileService;

import java.util.Optional;

/**
 * <p>
 * 系统-文件
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QFileEntity qFileEntity = QFileEntity.fileEntity;
        BlazeJPAQuery<FileEntity> blazeJPAQuery = new BlazeJPAQuery<FileEntity>(entityManager, criteriaBuilderFactory)
                .from(qFileEntity)
                .select(qFileEntity)
                .where(predicate).orderBy(qFileEntity.id.asc().nullsLast());
        PagedList<FileEntity> Files = blazeJPAQuery.fetchPage((int)pageable.getOffset(), pageable.getPageSize());

        return new PageRet(Files, Files.getTotalSize());
    }

    @Override
    public FileEntity save(FileSaveDTO dto) {
        FileEntity entity = new FileEntity();
        BeanUtils.copyProperties(dto, entity);
        return this.dao.save(entity);
    }

    @Override
    public FileEntity update(FileUpdateDTO dto) {
        Optional<FileEntity> optional = this.getById(dto.getId());
        optional.ifPresent(File -> {
            BeanUtils.copyProperties(dto, File);
            this.dao.save(File);
        });
        return optional.orElse(null);
    }
}
