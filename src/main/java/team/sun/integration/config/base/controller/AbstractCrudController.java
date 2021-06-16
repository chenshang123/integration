package team.sun.integration.config.base.controller;


/**
 * @Description:
 * @Author: xiaojunnuo
 * @CreateDate: 2018/12/29 0029$
 */
public class AbstractCrudController {
    /*public void setDefaultSort(Page page, String sortProp, boolean isDesc) {
        if(page!= null && page.getOrders()!= null && page.getOrders().size()>0){
           return;
        }
        if(isDesc){
            page.addOrder(OrderItem.desc(sortProp));
        }else{
            page.addOrder(OrderItem.asc(sortProp));
        }
    }

    public void betweenDateRange(LambdaQueryWrapper wrapper, SFunction column, String dateRange) {
        if(StringUtils.isNotBlank(dateRange)){
            String[] range = dateRange.split("-");
            wrapper.between(column, new Date(Long.parseLong(range[0])), new Date(Long.parseLong(range[1])));
        }
    }*/

}
