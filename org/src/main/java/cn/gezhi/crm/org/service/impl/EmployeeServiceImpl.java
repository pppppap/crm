package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.EmployeeMapper;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-14
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public PageModel<Employee> getEmployeePage(int page, int pageSize) {
        return getByExamplePage(page, pageSize, null);
    }

    public Employee getById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<Employee> getByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }

    public PageModel<Employee> getByExamplePage(int page, int pageSize, EmployeeExample example) {
        PageHelper.startPage(page, pageSize);
        List<Employee> employees = employeeMapper.selectByExample(example);
        return new PageModel<Employee>(employees);
    }

    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    public int save(Employee employee) {
        return employeeMapper.insert(employee);
    }

}
