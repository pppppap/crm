package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Department;

public interface DepartmentService {
 Department getOne(int id);
 int deleteOne(int id);
 int save(Department department);

}
