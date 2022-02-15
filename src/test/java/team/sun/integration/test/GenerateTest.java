package team.sun.integration.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.bulldozer.conversion.database.MysqlBasicType;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
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
        List<TableInfo> tableInfoList = tableService.get("sys_table");
        System.out.println(mapper.writeValueAsString(tableInfoList));
        //属性循环
        for (int i = 0; i < tableInfoList.size(); i++) {
            for (int i1 = 0; i1 < tableInfoList.get(i).getTableAttrs().size(); i1++) {
                tableInfoList.get(i).getTableAttrs().stream().forEach(attr -> {
                    System.out.println("属性名："+attr.getColumnName()+"------mysql-属性类型："+
                            attr.getDataType()+"-----java-属性类型："+
                            MysqlBasicType.basicTypes.get(attr.getDataType())+"-----属性说明："+attr.getColumnComment());
                });
            }
        }
        //多对一

        //多对多（判断维护方）

    }

}
