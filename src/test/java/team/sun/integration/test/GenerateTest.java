package team.sun.integration.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.TableEntity;
import team.sun.integration.modules.sys.table.service.TableService;

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
        //主动关系
        List<TableInfo> tableInfoList = tableService.get("sys_user");
        List<TableEntity> tableEntities = tableService.getTableEntity(tableInfoList);


        System.out.println(mapper.writeValueAsString(""));
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++");
    }



}
