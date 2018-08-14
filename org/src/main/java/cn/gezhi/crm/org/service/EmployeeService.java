package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-14
 */
public interface EmployeeService {
    PageModel<Employee> getEmployeePage(int page, int pageSize);

    Employee selectById(int id);
}
