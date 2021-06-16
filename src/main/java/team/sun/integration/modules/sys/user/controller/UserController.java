package team.sun.integration.modules.sys.user.controller;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BeanPath;
import com.querydsl.jpa.impl.JPAQuery;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.modules.base.model.dto.PageDTO;
import team.sun.integration.modules.base.model.vo.Ret;
import team.sun.integration.modules.sys.user.model.dto.query.UserQueryDTO;
import team.sun.integration.modules.sys.user.model.entity.QUser;
import team.sun.integration.modules.sys.user.model.entity.User;
import team.sun.integration.modules.sys.user.model.vo.page.UserPageVo;
import team.sun.integration.modules.sys.user.service.UserService;

import javax.validation.Valid;

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
    public Ret<UserPageVo> page(PageDTO pageDTO,@Valid @ModelAttribute UserQueryDTO queryDTO) {
        Pageable pageable = PageRequest.of(pageDTO.getPage() - 1, pageDTO.getSize());
        QUser user = QUser.user;
        Predicate predicate = user.isNotNull().or(user.isNull());


        /*User entity = new User();
        BeanUtils.copyProperties(queryDTO, entity);
        Wrapper<User> wrapper = Wrappers.lambdaQuery(entity);
        IPage<User> page = new Page<>(pageDTO.getCurrent(), pageDTO.getSize());
        if(pageDTO.getOrders().size()>0)page.orders().addAll(pageDTO.getOrders());
        userService.page(page, wrapper);*/
        return Ret.success();
    }


    /*@ApiOperation(value = "保存")
    @PostMapping("/save")
    public Ret<BusRetEnum> save(@Valid @RequestBody UserSaveDTO dto){
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        boolean state = userService.add(entity);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "修改")
    @PostMapping("/update")
    public Ret<BusRetEnum> update(@Valid @RequestBody UserUpdateDTO dto){
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        boolean state = userService.updateById(entity);
        return Ret.successOrFail(state);
    }


    @ApiOperation(value = "详情", response = User.class)
    @GetMapping("/dtl")
    public Ret<User> Detail(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id){
        User entity = userService.getById(id);
        if(null == entity){
            return Ret.fail(BusRetEnum.BUS_SEl_DETAIL_IS_NULL);
        }
        return Ret.success(entity);
    }

    @ApiOperation(value = "单个删除")
    @PostMapping("/delete")
    public Ret<BusRetEnum> delete(@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
        boolean state = userService.removeById(id);
        return Ret.successOrFail(state);
    }

    @ApiOperation(value = "批量删除")
    @PostMapping("/batchDelete")
    public Ret<BusRetEnum> batchDelete(@RequestBody List<String> ids) {
        boolean state = userService.removeByIds(ids);
        return Ret.successOrFail(state);
    }*/
}