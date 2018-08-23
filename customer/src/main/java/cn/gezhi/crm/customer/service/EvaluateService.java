package cn.gezhi.crm.customer.service;

import cn.gezhi.crm.customer.dto.CustomerQueryDTO;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.CustomerExample;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;
import cn.gezhi.crm.org.entity.PageModel;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/17
 */
public interface EvaluateService {
    CustomerCustom getById(int id);

    int update(Customer customer);

    int save(Customer customer);

    int deleteById(int id);

    PageModel<CustomerCustom> getCustomerPage(int page, int pageSize);

    PageModel<CustomerCustom> getCustomerPage(int page, int pageSize, CustomerExample customerExample);

    PageModel<CustomerCustom> getCustomerPage(CustomerQueryDTO queryDTO);
}