package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.EmployeeMapper;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import com.github.pagehelper.Page;
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
        PageHelper.startPage(page, pageSize);
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("id");

        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        PageModel<Employee> pageModel = new PageModel<Employee>(employees);
        return pageModel;
    }

    public Employee selectById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }
}
