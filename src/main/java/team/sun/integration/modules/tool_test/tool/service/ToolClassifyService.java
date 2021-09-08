package team.sun.integration.modules.tool_test.tool.service;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import team.sun.integration.config.base.model.vo.PageRet;
import team.sun.integration.config.base.service.IService;
import team.sun.integration.modules.sys.application.model.dto.update.ApplicationUpdateDTO;
import team.sun.integration.modules.sys.application.model.entity.Application;
import team.sun.integration.modules.tool_test.tool.model.dto.save.ToolClassifySaveDTO;
import team.sun.integration.modules.tool_test.tool.model.dto.update.ToolClassifyUpdateDTO;
import team.sun.integration.modules.tool_test.tool.model.entity.ToolClassify;

/**
 * <p>
 * 工器具-分类
 * </p>
 *
 * @author auto generator
 * @since 2021-08-06
 */
public interface ToolClassifyService extends IService<ToolClassify, String> {

    PageRet page(Pageable pageable, Predicate predicate, OrderSpecifier<?>... spec);

    ToolClassify save(ToolClassifySaveDTO entity);

    ToolClassify update(ToolClassifyUpdateDTO entity);
}
