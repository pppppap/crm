package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.EmployeeMapper;
import cn.gezhi.crm.org.dto.EmployeeDTO;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public PageModel<EmployeeDTO> getEmployeePage(int page, int pageSize) {
        return getByExamplePage(page, pageSize, null);
    }

    public EmployeeDTO getById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    public List<EmployeeDTO> getByExample(EmployeeExample example) {
        return employeeMapper.selectByExample(example);
    }

    public PageModel<EmployeeDTO> getByExamplePage(int page, int pageSize, EmployeeExample example) {
        PageHelper.startPage(page, pageSize);
        List<EmployeeDTO> employees = employeeMapper.selectByExample(example);
        return new PageModel<EmployeeDTO>(employees);
    }

    public int update(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int delete(int id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过工号或姓名搜索
     *
     * @param type 1:姓名,2:工号
     * @return 分页的结果
     */
    public PageModel<EmployeeDTO> getByKeyPage(int page, int pageSize, String type, String key) {
        EmployeeExample employeeExample = new EmployeeExample();
        if (StringUtils.isNotBlank(key)) {
            EmployeeExample.Criteria criteria = employeeExample.createCriteria();
            if (type.equals("1")) {
                criteria.andNameLike("%" + key + "%");
            } else if (type.equals("2")) {
                try {
                    criteria.andIdEqualTo(Integer.parseInt(key));
                } catch (NumberFormatException e) {
                    employeeExample = null;
                }
            }
        }
        return getByExamplePage(page, pageSize, employeeExample);
    }

    public int save(Employee employee) {
        return employeeMapper.insert(employee);
    }

    /**
     * 通过性别,部门,年龄段筛选员工
     *
     * @param map 里面有筛选的条件
     * @return 分页的结果
     */
    public PageModel<EmployeeDTO> getByFilterPage(int page, int pageSize, Map<String, String> map) {
        if (map.size() < 1) return getEmployeePage(page, pageSize);
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        String sex = map.get("sex");
        String department = map.get("dep_id");
        String age1 = map.get("age1");
        String age2 = map.get("age2");
        if (sex != null) criteria.andSexEqualTo(sex);
        if (department != null) criteria.andDepIdEqualTo(Integer.parseInt(department));
        if (age1 != null && age2 != null) {
            criteria.andAgeBetween(Integer.parseInt(age1), Integer.parseInt(age2));
        }
        return getByExamplePage(page, pageSize, example);
    }
}
