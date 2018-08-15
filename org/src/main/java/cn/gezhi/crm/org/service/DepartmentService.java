package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Department;

import java.util.List;

public interface DepartmentService {
 Department getOne(int id);
 int deleteOne(int id);
 int save(Department department);
 int update(Department department);
 int updateSelective(Department department);
 int saveSelective(Department department);
 List<Department> findSome(String keywords);
}
