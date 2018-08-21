package cn.gezhi.crm.customer.service;

import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.org.entity.PageModel;

import java.util.List;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/17
 */
public interface EvaluteService {
    Customer getById(int id);
    int update(Customer customer);
    int save(Customer customer);
    int deleteById(int id);
    PageModel<Customer> getCustomerPage(int page, int pageSize);
    List<Customer> getByEvaluteId(int id);
}