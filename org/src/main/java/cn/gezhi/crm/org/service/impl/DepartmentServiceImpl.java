package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.DepartmentMapper;
import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.DepartmentExample;
import cn.gezhi.crm.org.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
 *TODO 新增一个部门
 *@param department 部门的一个对象
 *@return 受影响的行数
 **/
    public int save(Department department) {
        return departmentMapper.insert(department);
    }
/**
 *TODO  修改一个部门的信息,没有修改的信息默认为null;
 *@param department 部门的一个对象,用做装修改属性的容器.
 *@return 受影响的行数
 **/
    public int update(Department department) {
        return departmentMapper.updateByPrimaryKey(department);
    }

    /**
     *TODO 有选择性的修改部门的休息,没有修改的信息保持不变
     *@param department 部门的一个对象,用做装修改属性的容器.
     *@return  受影响的行数
     **/
    public int updateSelective(Department department) {
        return departmentMapper.updateByPrimaryKeySelective(department);
    }
/**
 *TODO 有选择性的增加部门信息,没有增加的为null
 *@param department 部门的一个对象
 *@return 受影响的行数
 **/
    public int saveSelective(Department department) {
        return departmentMapper.insertSelective(department);
    }
/**
 *TODO 用生成的example做模糊查询
 *@param keywords 查询的关键字
 *@return  部门的集合
 **/
    public List<Department> findSome(String keywords) {
        DepartmentExample example=new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDepNameLike(keywords);
        return departmentMapper.selectByExample(example);
    }
}
