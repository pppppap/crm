package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;

import java.util.List;
import java.util.Map;

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

    PageModel<Employee> getByKeyPage(int page, int pageSize, String type, String key);

    PageModel<Employee> getByFilterPage(int page, int pageSize, Map<String,String> map);

    int update(Employee employee);

    int save(Employee employee);

    int delete(int id);


}