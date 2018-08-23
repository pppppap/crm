package cn.gezhi.crm.customer.service.impl;

import cn.gezhi.crm.customer.dao.CustomerCustomMapper;
import cn.gezhi.crm.customer.dao.CustomerMapper;
import cn.gezhi.crm.customer.dto.CustomerQueryDTO;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.CustomerExample;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;
import cn.gezhi.crm.customer.service.EvaluateService;
import cn.gezhi.crm.org.entity.PageModel;
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
public class EvaluteServiceImpl implements EvaluateService {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerCustomMapper customerCustomMapper;

    /**
     * 根据ID查询客户
     *
     * @param id 客户的ID
     * @return 一个客户的对象
     **/
    public CustomerCustom getById(int id) {
        return customerCustomMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据ID更新客户
     *
     * @param customer 一个客户的对象
     * @return 受影响的行数
     **/
    public int update(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 新增一个客户
     *
     * @param customer 一个客户的对象
     * @return 受影响的行数
     **/
    public int save(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 根据ID删除用户
     *
     * @param id 客户的ID
     * @return 受影响的行数
     **/
    public int deleteById(int id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询客户并分页显示
     *
     * @param page 显示当前页面 pageSize 页面显示数目
     * @return 一个包含客户的page分页模型
     **/
    public PageModel<CustomerCustom> getCustomerPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<CustomerCustom> customers = customerCustomMapper.selectByExample(null);
        return new PageModel<CustomerCustom>(customers);
    }


    public PageModel<CustomerCustom> getCustomerPage(int page, int pageSize, CustomerExample customerExample) {
        PageHelper.startPage(page, pageSize);
        List<CustomerCustom> customers = customerCustomMapper.selectByExample(customerExample);
        return new PageModel<CustomerCustom>(customers);
    }

    /**
     * 根据 queryDTO查询
     *
     * @param queryDTO 封装了查询的条件
     * @return
     */
    public PageModel<CustomerCustom> getCustomerPage(CustomerQueryDTO queryDTO) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();


        if (queryDTO.getName() != null) {
            criteria.andNameLike("%" + queryDTO.getName() + "%");
        }
        if (queryDTO.getAttentionLevel() != null) {
            criteria.andAttentionLevelEqualTo(queryDTO.getAttentionLevel());
        }
        if (queryDTO.getCustomerLevel() != null) {
            criteria.andCustomerLevelEqualTo(queryDTO.getCustomerLevel());
        }
        if (queryDTO.getIdcard() != null) {
            criteria.andIdcardLike("%" + queryDTO.getIdcard() + "%");
        }
        if (queryDTO.getSecurityId() != null) {
            criteria.andSecurityIdEqualTo(queryDTO.getSecurityId());
        }
        if (queryDTO.getTel() != null) {
            criteria.andTelLike("%" + queryDTO.getTel() + "%");
        }
        if (queryDTO.getProcess() != null) {
            criteria.andProcessEqualTo(queryDTO.getProcess());
        }
        if (queryDTO.getEvaluteId() != null) {
            criteria.andEvaluteIdEqualTo(queryDTO.getEvaluteId());
        }
        if (queryDTO.getSalesmanId() != null) {
            criteria.andSalesmanIdEqualTo(queryDTO.getSalesmanId());
        }
        if (queryDTO.getBankId() != null) {
            criteria.andBankIdEqualTo(queryDTO.getBankId());
        }

        return getCustomerPage(queryDTO.page, queryDTO.pageSize, example);
    }

}