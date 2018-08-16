package cn.gezhi.crm.customer.dao;

import cn.gezhi.crm.customer.entity.Bank;
import cn.gezhi.crm.customer.entity.BankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankMapper {
    int countByExample(BankExample example);

    int deleteByExample(BankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);

    int insertSelective(Bank record);

    List<Bank> selectByExample(BankExample example);

    Bank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
}