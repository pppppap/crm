package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.DepartmentMapper;
import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/14
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     *TODO 根据ID查询一个部门
     *@param id 部门的编号
     *@return  部门对象
     **/

    public Department getOne(int id) {

        return departmentMapper.selectByPrimaryKey(id);
    }
/**
 *TODO 根据ID删除一个部门
 *@param id 部门的编号
 *@return  受影响的行数
 **/
    public int deleteOne(int id) {
        return departmentMapper.deleteByPrimaryKey(id);
    }
/**
 *TODO
 *@param
 *@return
 **/
    public int save(Department department) {
        return departmentMapper.insert(department);
    }
}
