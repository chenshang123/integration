package team.sun.integration.modules.sys.table.service.impl;

import com.google.common.base.CaseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import team.sun.integration.common.base.service.impl.ServiceImpl;
import team.sun.integration.modules.bulldozer.conversion.database.BasicTypeConversion;
import team.sun.integration.modules.sys.table.model.entity.TableAttr;
import team.sun.integration.modules.sys.table.model.entity.TableInfo;
import team.sun.integration.modules.sys.table.model.vo.EntityAttr;
import team.sun.integration.modules.sys.table.model.vo.EntityRelation;
import team.sun.integration.modules.sys.table.repository.TableAttrDao;
import team.sun.integration.modules.sys.table.service.TableAttrService;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 系统-表信息：表字段属性
 * </p>
 *
 * @author auto generator
 * @since 2021-12-14
 */
@Service
public class TableAttrServiceImpl extends ServiceImpl<TableAttrDao, TableAttr> implements TableAttrService {

    private final TableAttrDao tableAttrDao;

    @Autowired
    public TableAttrServiceImpl(TableAttrDao tableAttrDao) {
        this.tableAttrDao = tableAttrDao;
    }

    @Override
    public TableAttr getUserById(String id) {
        return this.tableAttrDao.findById(id).orElse(null);
    }

    @Override
    public List<EntityAttr> getEntityAttr(TableInfo tableInfo) {
        if(null != tableInfo && null != tableInfo.getTableAttrs()){
            List<EntityAttr> entityAttrs = new ArrayList<>(tableInfo.getTableAttrs().size());
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
            return entityAttrs;
        }
        return null;
    }

    @Override
    public List<EntityRelation> getManyToMany(List<EntityRelation> tableConstraints) {
        if (null != tableConstraints){
            for (EntityRelation entityRelation : tableConstraints){
                if(StringUtils.hasLength(entityRelation.getConstraintName()) &&
                        entityRelation.getConstraintName().startsWith(entityRelation.getTableName())){
                    //关系维护方
                    entityRelation.setMaintainer(true);
                }else{
                    //关系被维护方
                    entityRelation.setMaintainer(false);
                }
                entityRelation.setType("mtm");
            }
        }
        return tableConstraints;
    }

    @Override
    public List<EntityRelation> getOtherRelation(List<EntityAttr> entityAttrs, List<EntityRelation> tableConstraints) {
        if(null != tableConstraints && !tableConstraints.isEmpty() &&
                null != entityAttrs && !entityAttrs.isEmpty()){
           for(EntityAttr entityAttr : entityAttrs){
               if (entityAttr != null && null != entityAttr.getComment()){
                    if(entityAttr.getComment().startsWith("mto")){

                    }else if(entityAttr.getComment().startsWith("otm")){

                    }else if(entityAttr.getComment().startsWith("oto")){

                    }
               }
           }
        }
        return null;
    }


}
