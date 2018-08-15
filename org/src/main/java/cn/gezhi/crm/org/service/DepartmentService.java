package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.*;

import java.util.List;

public interface DepartmentService {
    Department getOne(int id);

    int deleteOne(int id);

    int save(Department department);

    int update(Department department);

    int updateSelective(Department department);

    int saveSelective(Department department);

    List<Department> findSome(String keywords);

    List<Department> getAll(DepartmentExample example);

    PageModel<Department> getDepartmentPage(int page, int pageSize);

    PageModel<Department> getByExamplePage(int page, int pageSize, DepartmentExample example);
}
