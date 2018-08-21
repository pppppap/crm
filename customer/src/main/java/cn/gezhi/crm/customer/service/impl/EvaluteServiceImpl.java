package cn.gezhi.crm.customer.service.impl;

import cn.gezhi.crm.customer.dao.CustomerMapper;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.CustomerExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.customer.service.EvaluteService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权证员功能类
 *
 * @author jinlu
 * @date 2018/8/17
 */
@Service
public class EvaluteServiceImpl implements EvaluteService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 根据ID查询客户
     * @param id 客户的ID
     * @return 一个客户的对象
     **/
    public Customer getById(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID更新客户
     * @param customer 一个客户的对象
     * @return 受影响的行数
     **/
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 新增一个客户
     * @param customer 一个客户的对象
     * @return 受影响的行数
     **/
    public int save(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 根据ID删除用户
     * @param id 客户的ID
     * @return 受影响的行数
     **/
    public int deleteById(int id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询客户并分页显示
     * @param page 显示当前页面 pageSize 页面显示数目
     * @return 一个包含客户的page分页模型
     **/
    public PageModel<Customer> getCustomerPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        CustomerExample customerExample = new CustomerExample();
       customerExample.setOrderByClause("id");
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        PageModel<Customer> pageModel = new PageModel<Customer>(customers);
        return pageModel;
    }

    /**
     * 根据权证员ID查询客户
     * @param id 权证员的ID
     * @return 一个客户的集合
     **/
    public List<Customer> getByEvaluteId(int id) {
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        criteria.andEvaluteIdEqualTo(id);
        return  customerMapper.selectByExample(customerExample);
    }
}