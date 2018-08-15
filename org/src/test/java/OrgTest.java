import cn.gezhi.crm.org.dao.DepartmentMapper;
import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.DepartmentExample;
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
    private DepartmentMapper departmentMapper;

   /**
    *TODO
    *@param
    *@return
    **/
    @Test
    public void testSelectByPrimaryKey() {
        Department department = departmentMapper.selectByPrimaryKey(1);
        System.out.println(department);
    }
    @Test
    public void testInsert() {
        Department department=new Department();
        department.setId(5);
        department.setDepName("外交部");
        department.setDepDesc("应酬");
        int insert = departmentMapper.insert(department);
        System.out.println(insert);


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
}
