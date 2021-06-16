package team.sun.integration.modules.sys.config.controller;

import team.sun.integration.modules.sys.config.service.CodeValueService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统-码值 前端控制器
 * </p>
 *
 * @author auto generator
 * @since 2021-03-03
 */
@Api(tags = "系统-码值")
@RestController
@RequestMapping("/sys/config/codeValue")
public class CodeValueController {

    private final CodeValueService codeValueService;

    @Autowired
    public CodeValueController(CodeValueService codeValueService) {
        this.codeValueService = codeValueService;
    }

   /*@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public Ret page(CodeValueQueryDTO queryDTO){
        queryDTO.setViewName(ViewSelectionEnum.VIEW_MANUFACTURER.getView());
        return Ret.success(codeValueService.getView(queryDTO));
    }*/
//    //查询厂家信息 manufacturer
//    VIEW_MANUFACTURER(1,"view_selection_manufacturer"),
//    //地市查询 3.4 city
//    VIEW_CITY(2,"view_selection_city"),
//    //区县 5.6 county
//    VIEW_COUNTY(3,"view_selection_county"),
//    //班组 team
//    VIEW_TEAM(4,"view_selection_team"),
//    //查询库房信息 storeroom
//    VIEW_STOREROOM(5,"view_selection_storeroom"),
//    //工器具分类类型 classify
//    VIEW_CLASSIFY_ONE(6,"view_selection_classify"),
//    VIEW_CLASSIFY_TWO(7,"view_selection_classify"),
//    VIEW_CLASSIFY_THREE(8,"view_selection_classify");

}