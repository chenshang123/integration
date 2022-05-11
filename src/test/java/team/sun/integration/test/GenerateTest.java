package team.sun.integration.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.bulldozer.generate.freemarker.LoadData;
import team.sun.integration.modules.bulldozer.generate.freemarker.PathProperties;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.TableEntity;
import team.sun.integration.modules.sys.table.service.TableService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

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

        Map<String, Object> data = new HashMap<>();
        data.put("packagePath", PathProperties.getPackagePath());
        try {
            LoadData loadData = new LoadData();
            tableEntities.forEach(o -> {
                data.put("entity", o);
                loadData.ToJavaFtl(PathProperties.getModelEntityFtlPath(), PathProperties.getModelEntityOutPath()+o.getClassName()+".java", data);
//                replaceAll(this.getPathSpacer(), Matcher.quoteReplacement(File.separator))

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(mapper.writeValueAsString(""));
        System.out.println("++++++++++++++++++++");
    }



}
