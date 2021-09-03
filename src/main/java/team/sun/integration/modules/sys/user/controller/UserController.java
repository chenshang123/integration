package team.sun.integration.modules.sys.user.controller;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.config.base.enums.ret.BusRetEnum;
import team.sun.integration.config.base.model.dto.PageDTO;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.modules.sys.user.model.dto.query.UserQueryDTO;
import team.sun.integration.modules.sys.user.model.dto.save.UserSaveDTO;
import team.sun.integration.modules.sys.user.model.dto.update.UserUpdateDTO;
import team.sun.integration.modules.sys.user.model.entity.QUser;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 系统-用户 前端控制器
 * </p>
 *
 * @author chens
 * @since 2021-02-01
 */
@Api(tags = "系统-用户")
@RestController
@RequestMapping("/sys/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(PageDTO pageDTO, @Valid @ModelAttribute UserQueryDTO queryDTO){
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getPageSize());
        QUser qUser = QUser.user;
        User entity = new User();
        BeanUtils.copyProperties(queryDTO, entity);

        Predicate predicate = qUser.isNotNull().or(qUser.isNull());
        PageRet pageRet = userService.page(pageable, predicate, null);
        return Ret.success(pageRet);
    }


    @ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret save(@Valid @RequestBody UserSaveDTO dto){
        userService.save(dto);
        return Ret.success();
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret update(@Valid @RequestBody UserUpdateDTO dto){
        userService.update(dto);
        return Ret.success();
    }


    @ApiOperation(value = "详情", response = User.class)
    @GetMapping("/dtl")
    public Ret Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id){
        Optional<User> entity = userService.getById(id);
        return entity.map(Ret::success).orElseGet(() -> Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL));
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        userService.removeById(id);
        return Ret.success();
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret batchDelete(@RequestBody List<String> ids) {
        userService.removeAllByIds(ids);
        return Ret.success();
    }
}