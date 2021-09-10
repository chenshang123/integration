package team.sun.integration.modules.tool_test.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import team.sun.integration.config.base.model.vo.Ret;
import team.sun.integration.modules.tool_test.test.model.vo.StandardTest;
import team.sun.integration.modules.tool_test.test.model.vo.ToolTestDataVo;
import team.sun.integration.modules.tool_test.test.model.vo.VisualInspection;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 工器具-检验
 * </p>
 *
 * @author auto generator
 * @since 2021-08-16
 */
@Api(tags = "工器具-检验")
@RestController
@RequestMapping("/sys/test")
public class TestController {

    @ApiOperation(value = "试验数据", response = ToolTestDataVo.class)
    @GetMapping("/data")
    public Ret Detail(@ApiParam(name = "batchCode", value = "batchCode", required = true) @RequestParam String batchCode,
                      @ApiParam(name = "epc", value = "epc", required = true) @RequestParam String epc) {
        ToolTestDataVo dataVo = new ToolTestDataVo();

        VisualInspection visualInspection = new VisualInspection();
        List<VisualInspection> visualInspections = new ArrayList<>();
        visualInspections.add(visualInspection);

        StandardTest standardTest = new StandardTest();
        List<StandardTest> standardTests = new ArrayList<>();
        dataVo.setStandardTests(standardTests);

        dataVo.setVisualInspections(visualInspections);
        return Ret.success(dataVo);
    }


}