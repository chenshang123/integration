package team.sun.integration.modules.bulldozer.extend.querydsl.criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索条件
 */
public class SearchCriteria {

    /**
     * 对象名称
     */
    private String tableName;
    /**
     * 条件集合
     */
    private List<Criteria> criteriaList;

    public List<String> getKeys() {
        if (!criteriaList.isEmpty()) {
            List<String> keys = new ArrayList<>(criteriaList.size());
            criteriaList.forEach(criteria -> keys.add(criteria.getKey()));
            return keys;
        }
        return null;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }


}
