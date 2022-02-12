package team.sun.integration.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.service.TableAttrService;
import team.sun.integration.modules.sys.table.service.TableService;
import team.sun.integration.modules.sys.user.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenerateTest {
    @Autowired
    private TableService tableService;
    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void test() throws JsonProcessingException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        List<TableInfo> tableInfoList = tableService.get("sys_table");
        System.out.println(mapper.writeValueAsString(tableInfoList));
        //属性循环

        //

    }

}
