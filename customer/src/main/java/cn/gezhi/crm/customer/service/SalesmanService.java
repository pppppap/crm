package cn.gezhi.crm.customer.service;

import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.org.entity.PageModel;

import java.util.List;

/**
 * TODO
 *
 * @author chenxianbin
 * @date 2018/8/23
 */
public interface SalesmanService {
    PageModel<Customer> getCustomerPage (int page, int pageSize);
    List<Customer> getBySalesmanId (int id);

    Customer getById(Integer id);
    int update (Customer customer);
    int save (Customer customer);
    //业务员删除取消预约的客户
    int deleteById (Integer id);
}
