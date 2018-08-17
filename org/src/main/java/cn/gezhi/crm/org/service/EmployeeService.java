package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.dto.EmployeeDTO;
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
    PageModel<EmployeeDTO> getEmployeePage(int page, int pageSize);

    EmployeeDTO getById(int id);

    List<EmployeeDTO> getByExample(EmployeeExample example);

    PageModel<EmployeeDTO> getByExamplePage(int page, int pageSize, EmployeeExample example);

    PageModel<EmployeeDTO> getByKeyPage(int page, int pageSize, String type, String key);

    PageModel<EmployeeDTO> getByFilterPage(int page, int pageSize, Map<String,String> map);

    int update(Employee employee);

    int save(Employee employee);

    int delete(int id);


}