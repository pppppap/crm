package cn.gezhi.crm.customer.dao;

import cn.gezhi.crm.customer.entity.CustomerExample;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;

import java.util.List;

/**
 * TODO
 *
 * @author pppppap
 */
public interface CustomerCustomMapper {

    List<CustomerCustom> selectByExample(CustomerExample example);

    CustomerCustom selectByPrimaryKey(int id);

}
