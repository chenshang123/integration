package team.sun.integration.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import team.sun.integration.modules.bulldozer.conversion.database.BasicTypeConversion;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.EntityAttr;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;
import team.sun.integration.modules.sys.table.service.TableService;

import java.util.ArrayList;
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

        //属性循环
        for (TableInfo tableInfo : tableInfoList) {
            List<EntityAttr> entityAttrs = new ArrayList<>(tableInfoList.size());
            tableInfo.getTableAttrs().forEach(attr -> {
                EntityAttr entityAttr = new EntityAttr();
                entityAttr.setHumpName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, attr.getColumnName()));
                entityAttr.setDataType(BasicTypeConversion.MysqlAndJava.get(attr.getDataType()));
                entityAttr.setComment(attr.getColumnComment());
                entityAttr.setAttrDefault(attr.getColumnDefault());
                entityAttr.setIsNullable(attr.getIsNullable());
                entityAttr.setCharacterMaximumLength(attr.getCharacterMaximumLength());
                entityAttrs.add(entityAttr);
                    }
            );

        }
        System.out.println("--------------------");
        System.out.println("--------------------");
        //多对一或者一对一
        for (TableInfo tableInfo : tableInfoList) {
            if(null != tableInfo.getTableConstraints()){
                List<EntityRelation> entityRelations = new ArrayList<>(tableInfo.getTableConstraints().size());
                tableInfo.getTableConstraints().forEach(tableConstraint -> {
                    EntityRelation entityRelation = new EntityRelation();
                    entityRelation.setConstraintName(tableConstraint.getConstraintName());
                    entityRelation.setTableName(tableConstraint.getTable().getTableName());
                    entityRelation.setAttrName(tableConstraint.getColumnName());
                    entityRelation.setReferencedTableName(tableConstraint.getReferencedTable().getTableName());
                    entityRelation.setReferencedAttrName(tableConstraint.getReferencedColumnName());
                    entityRelations.add(entityRelation);
                });
                System.out.println(mapper.writeValueAsString(entityRelations));
            }
        }
        //多对多或者一对多（外键关系）
        for (TableInfo tableInfo : tableInfoList) {
            if(null != tableInfo.getReferencedTableConstraints()){
                List<EntityRelation> entityReferencedRelations = new ArrayList<>(tableInfo.getReferencedTableConstraints().size());
                tableInfo.getReferencedTableConstraints().forEach(tableConstraint -> {
                    EntityRelation entityRelation = new EntityRelation();
                    entityRelation.setConstraintName(tableConstraint.getConstraintName());
                    entityRelation.setTableName(tableConstraint.getTable().getTableName());
                    entityRelation.setAttrName(tableConstraint.getColumnName());
                    entityRelation.setReferencedTableName(tableConstraint.getReferencedTable().getTableName());
                    entityRelation.setReferencedAttrName(tableConstraint.getReferencedColumnName());
                    entityReferencedRelations.add(entityRelation);
                });
                System.out.println(mapper.writeValueAsString(entityReferencedRelations));
            }
        }
        System.out.println("++++++++++++++++++++");
        System.out.println("++++++++++++++++++++");
    }

}
