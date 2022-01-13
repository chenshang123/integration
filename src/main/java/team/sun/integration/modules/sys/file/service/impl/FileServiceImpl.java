package team.sun.integration.modules.sys.file.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.exception.UploadException;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.file.model.dto.save.FileSaveDTO;
import team.sun.integration.modules.sys.file.model.dto.update.FileUpdateDTO;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.entity.QFileEntity;
import team.sun.integration.modules.sys.file.model.properties.FileProperties;
import team.sun.integration.modules.sys.file.model.vo.FileVO;
import team.sun.integration.modules.sys.file.repository.FileDao;
import team.sun.integration.modules.sys.file.service.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

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

    private final FileProperties fileProperties;

    @Autowired(required = false)
    public FileServiceImpl(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
    }

    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QFileEntity qFileEntity = QFileEntity.fileEntity;
        BlazeJPAQuery<FileEntity> blazeJPAQuery = new BlazeJPAQuery<FileEntity>(entityManager, criteriaBuilderFactory)
                .from(qFileEntity)
                .select(qFileEntity)
                .where(predicate).orderBy(qFileEntity.id.asc().nullsLast());
        PagedList<FileEntity> pages = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(pages, pages.getTotalPages());
    }

    @Override
    public List<FileVO> get(String businessId) {
        List<FileEntity> fileEntities = dao.findByBusinessId(businessId);
        return Optional.ofNullable(fileEntities).orElseGet(ArrayList::new).stream().filter(Objects::nonNull).map(entity -> {
            FileVO fileVO = new FileVO();
            BeanUtils.copyProperties(entity, fileVO);
            return fileVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<String> getNames(String businessId) {
        List<FileEntity> fileVOS = dao.findByBusinessId(businessId);
        return Optional.ofNullable(fileVOS).orElse(new ArrayList<>()).stream().map(FileEntity::getName).collect(Collectors.toList());
    }

    @Override
    public String getPath(String name) {
        FileEntity vo = dao.findByName(name);
        if (StringUtils.hasLength(vo.getName()) && StringUtils.hasLength(vo.getStorageUrl())) {
            return fileProperties.getUploadPath() + File.separator +
                    vo.getStorageUrl().replaceAll(fileProperties.getPathSpacer(), Matcher.quoteReplacement(File.separator)) +
                    File.separator + vo.getName();
        }
        return null;
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
        if (optional.isPresent()) {
            BeanUtils.copyProperties(dto, optional.get());
            this.dao.save(optional.get());
        }
        return optional.orElse(null);
    }

    @Override
    public Ret upload(HttpServletRequest request) {
        String message = "";
        try {
            List<FileEntity> fileEntities = fileProperties.upload(request);
            if (fileEntities.size() > 0) {
                this.saveOrUpdateBatch(fileEntities);
                return Ret.success(fileEntities.get(0).getBusinessId());
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_SINGLE_OVERRUN.getValue();
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_OVERRUN.getValue();
        } catch (UploadException e) {
            e.printStackTrace();
            message = e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_IO_ERROR.getValue();
        } catch (Exception e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_UPLOAD_ERROR.getValue();
        }
        return Ret.success(message);
    }

    @Override
    public void downloadLocalImg(HttpServletResponse response, String name) {
        String path = this.getPath(name);
        try {
            fileProperties.downloadLocal(path, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
