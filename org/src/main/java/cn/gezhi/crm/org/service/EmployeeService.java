package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-14
 */
public interface EmployeeService {
    PageModel<Employee> getEmployeePage(int page, int pageSize);

    Employee getById(int id);

    List<Employee> getByExample(EmployeeExample example);

    PageModel<Employee> getByExamplePage(int page, int pageSize, EmployeeExample example);

    int update(Employee employee);

    int save(Employee employee);
}
