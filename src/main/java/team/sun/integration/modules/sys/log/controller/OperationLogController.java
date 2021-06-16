package team.sun.integration.modules.sys.log.controller;

import team.sun.integration.modules.sys.log.service.OperationLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-02-02
 */
@Api(tags = "系统-操作日志：	1.日志包含时间、地点（方法）、人物	2.还原操作，记录参数、影响内容")
@RestController
@RequestMapping("/sys/resource/operationLog")
public class OperationLogController {

    private final OperationLogService operationLogService;

    @Autowired
    public OperationLogController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO,@Valid @ModelAttribute OperationLogQueryDTO queryDTO){
        OperationLog entity = new OperationLog();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<OperationLog> wrapper = Wrappers.lambdaQuery(entity);
        IPage<OperationLog> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        operationLogService.page(page, wrapper);
        return Ret.success(page);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody OperationLogSaveDTO dto){
        OperationLog entity = new OperationLog();
        BeanUtils.copyProperties(dto, entity);
        boolean state = operationLogService.save(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody OperationLogUpdateDTO dto){
        OperationLog entity = new OperationLog();
        BeanUtils.copyProperties(dto, entity);
        boolean state = operationLogService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = OperationLog.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id){
        OperationLog entity = operationLogService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        boolean state = operationLogService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<Long> ids) {
        boolean state = operationLogService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}