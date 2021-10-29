package team.sun.integration.modules.sys.file.service.impl;

import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.querydsl.BlazeJPAQuery;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.exception.UploadException;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.config.base.service.impl.ServiceImpl;
import team.sun.integration.modules.sys.file.model.dto.save.FileSaveDTO;
import team.sun.integration.modules.sys.file.model.dto.update.FileUpdateDTO;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.entity.QFileEntity;
import team.sun.integration.modules.sys.file.model.properties.FileProperties;
import team.sun.integration.modules.sys.file.repository.FileDao;
import team.sun.integration.modules.sys.file.service.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
@Service
public class FileServiceImpl extends ServiceImpl<FileDao, FileEntity> implements FileService {

    private final FileProperties fileProperties;

    @Autowired(required = false)
    public FileServiceImpl(FileProperties fileProperties){
        this.fileProperties = fileProperties;
    }
    @Override
    public PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec) {
        QFileEntity qFileEntity = QFileEntity.fileEntity;
        BlazeJPAQuery<FileEntity> blazeJPAQuery = new BlazeJPAQuery<FileEntity>(entityManager, criteriaBuilderFactory)
                .from(qFileEntity)
                .select(qFileEntity)
                .where(predicate).orderBy(qFileEntity.id.asc().nullsLast());
        PagedList<FileEntity> Files = blazeJPAQuery.fetchPage((int) pageable.getOffset(), pageable.getPageSize());

        return new PageRet(Files, Files.getTotalSize());
    }

    @Override
    public List<FileEntity> getByBusinessId(String businessId) {
        return this.dao.findByBusinessId(businessId);
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

    @Override
    public Ret upload(HttpServletRequest request) {
        String tempPath = fileProperties.getTempPath();
        File tmpFile = new File(tempPath);
        if (!tmpFile.exists()) {
            if (!tmpFile.mkdir()){
                throw new UploadException(BusRetEnum.BUS_FILE_PATH_ERROR.getMsg());
            }
        }
        String message = null;
        try {
            // 1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个
            // 临时文件存放到指定的临时目录当中。设置缓冲区的大小为100KB，其默认大小是10KB
            factory.setSizeThreshold(1024 * 100);
            // 设置上传时生成的临时文件的保存目录
            factory.setRepository(tmpFile);
            // 2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 解决上传文件名的中文乱码
            upload.setHeaderEncoding(fileProperties.getCodeSet());
            upload.setFileSizeMax(fileProperties.getFileSizeMax());
            upload.setSizeMax(fileProperties.getSizeMax());
            // 3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                // 按照传统方式获取数据
                return Ret.fail();
            }
            // 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的
            List<FileItem> list = upload.parseRequest(request);
            List<FileEntity> fileEntities = new ArrayList<>(list.size());
            byte[] fileBytes;
            for (FileItem item : list) {
                if (item.isFormField()) {
                    //普通输入项的数据，暂时不处理
                    return Ret.fail();
                } else {
                    String filename = item.getName();
                    // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的
                    InputStream in = item.getInputStream();
                    fileBytes = fileProperties.InputStreamToByte(in);
                    in.close();
                    item.delete();
                    FileEntity fileEntity = fileProperties.makeFileEntity(filename);
                    // 文件类型是否合法
                    if(fileProperties.extNameCheck(filename, fileProperties.getAllowImgExtName())){
                        fileEntities.add(fileProperties.saveImg(fileEntity, fileBytes));
                    }else{
                        throw new UploadException(BusRetEnum.BUS_FILE_TYPE_NOT_SUPPORTED.getMsg());
                    }
                }
            }
            this.dao.save(fileEntities.get(0));
            //this.saveOrUpdateBatch(fileEntities);
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_SINGLE_OVERRUN.getValue();
        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_OVERRUN.getValue();
        } catch (IOException e){
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_IO_ERROR.getValue();
        }catch (Exception e) {
            e.printStackTrace();
            message = BusRetEnum.BUS_FILE_UPLOAD_ERROR.getValue();
        }
        return Ret.success(message);
    }
}
