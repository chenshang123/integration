package team.sun.integration.modules.sys.file.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.common.base.enums.ret.BusRetEnum;
import team.sun.integration.common.base.model.dto.PageDTO;
import team.sun.integration.common.base.model.vo.PageRet;
import team.sun.integration.common.base.model.vo.Ret;
import team.sun.integration.modules.sys.file.model.dto.query.FileQueryDTO;
import team.sun.integration.modules.sys.file.model.dto.save.FileSaveDTO;
import team.sun.integration.modules.sys.file.model.dto.update.FileUpdateDTO;
import team.sun.integration.modules.sys.file.model.entity.FileEntity;
import team.sun.integration.modules.sys.file.model.entity.QFileEntity;
import team.sun.integration.modules.sys.file.service.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
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
@Api(tags = "系统-文件")
@RestController
@RequestMapping("/sys/file")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation(value = "图片本地下载")
    @PostMapping("/upload/img")
    protected Ret upload(HttpServletRequest request) {
        return fileService.upload(request);
    }

    @ApiOperation(value = "图片本地下载")
    @GetMapping("/download/Local/Img")
    public void downLoad(HttpServletResponse response,
                         @ApiParam(name = "name", value = "name", required = true) @RequestParam String name) {
        fileService.downloadLocalImg(response, name);

    }

    @ApiOperation(value = "获取文件路径集合")
    @GetMapping("/urls")
    @ResponseBody
    public Ret urls(@ApiParam(name = "businessId", value = "businessId", required = true) @RequestParam String businessId) {
        return Ret.success(fileService.getNames(businessId));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute FileQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QFileEntity qFileEntity = QFileEntity.fileEntity;
        FileEntity entity = new FileEntity();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qFileEntity.isNotNull().or(qFileEntity.isNull());
        PageRet pageRet = fileService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody FileSaveDTO dto) {
        fileService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody FileUpdateDTO dto) {
        fileService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = File.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        Optional<FileEntity> entity = fileService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        fileService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        fileService.removeAllByIds(ids);
        return Ret.success();
    }
}