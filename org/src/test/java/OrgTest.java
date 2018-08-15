<<<<<<< HEAD
import cn.gezhi.crm.org.dao.DepartmentMapper;
import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.DepartmentExample;
=======
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
>>>>>>> upstream/master
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * TODO
 *
 * @author pppppap
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-placeholder.xml", "classpath:spring/application*.xml"})
public class OrgTest {
    @Autowired
<<<<<<< HEAD
    private DepartmentMapper departmentMapper;
=======
    private EmployeeService employeeService;
>>>>>>> upstream/master

   /**
    *TODO
    *@param
    *@return
    **/
    @Test
<<<<<<< HEAD
    public void testSelectByPrimaryKey() {
        Department department = departmentMapper.selectByPrimaryKey(1);
        System.out.println(department);
=======
    public void test1() {
        PageModel<Employee> pageModel = employeeService.getEmployeePage(1, 3);
        System.out.println(pageModel);
        System.out.println(pageModel.getTotalCount());
        System.out.println(pageModel.getCurrentPage());
        for (Employee employee : pageModel.getList()) {
            System.out.println(employee);
        }
>>>>>>> upstream/master
    }
    @Test
    public void testInsert() {
        Department department=new Department();
        department.setId(5);
        department.setDepName("外交部");
        department.setDepDesc("应酬");
        int insert = departmentMapper.insert(department);
        System.out.println(insert);


<<<<<<< HEAD
    }
   @Test
    public void testDelete(){
       int i = departmentMapper.deleteByPrimaryKey(5);
       System.out.println(i);
   }
    @Test
   public void testInsertSelective(){
       Department department=new Department();
       department.setDepDesc("应酬");
        departmentMapper.insertSelective(department);
   }
   @Test
   public  void testExample(){
       DepartmentExample example =new DepartmentExample();
       DepartmentExample.Criteria criteria = example.createCriteria();
       DepartmentExample.Criteria criteria1 = criteria.andDepNameLike("%门%");
       List<Department> departments = departmentMapper.selectByExample(example);
       for (Department department : departments) {
           System.out.println(department);
       }
   }
=======
    @Test
    public void test2() {
        Employee employee = new Employee();
        employee.setCareerId(2);
        employee.setDepId(2);
        employee.setName("张四");
        employee.setDeleteFlag(0);
        int n = employeeService.save(employee);
        System.out.println(n);
    }
>>>>>>> upstream/master
}
