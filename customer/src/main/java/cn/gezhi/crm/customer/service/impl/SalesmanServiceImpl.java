package cn.gezhi.crm.customer.service.impl;

import cn.gezhi.crm.customer.dao.CustomerMapper;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.CustomerExample;
import cn.gezhi.crm.customer.service.SalesmanService;
import cn.gezhi.crm.org.entity.PageModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author chenxianbin
 * @date 2018/8/23
 */
@Service
public class SalesmanServiceImpl implements SalesmanService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     *  查询客户并分页显示
     * @param page 当前显示的页面
     * @param pageSize 页面显示的信息条数
     * @return 分页
     */
    public PageModel<Customer> getCustomerPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);   //指定开始是第几页，每页显示的信息条数
        CustomerExample customerExample = new CustomerExample();
        customerExample.setOrderByClause("id"); //查询结果通过id来排序
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        return new PageModel<Customer>(customers);

    }

    /**
     *  业务员根据自己id查询经手的客户
     * @param id 业务员id
     * @return 经手的客户
     */
    public List<Customer> getBySalesmanId(int id) {
        CustomerExample customerExample = new CustomerExample(); //创建一个customerExample对象
        CustomerExample.Criteria criteria = customerExample.createCriteria(); //创建一个criteria对象
        criteria.andSalesmanIdEqualTo(id); //添加条件
        return customerMapper.selectByExample(customerExample); //调用select语句
    }

    /**
     *  根据id查询客户
     * @param id 客户id
     * @return 受影响行数
     */
    public Customer getById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     *  修改客户数据
     * @param customer 一个客户对象
     * @return 受影响行数
     */
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    /**
     *  新增一个客户
     * @param customer 一个客户对象
     * @return 受影响行数
     */
    public int save(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     *  业务员根据id删除取消预约的客户
     * @param id 预约客户的id
     * @return 受影响行数
     */
    public int deleteById(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }
}
