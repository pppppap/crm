import cn.gezhi.crm.org.dao.DepartmentMapper;
import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.DepartmentExample;
import cn.gezhi.crm.org.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-placeholder.xml","classpath:spring/application*.xml"})
public class OrgTest {
@Autowired
private DepartmentService departmentService;
    @Test
    public  void testExample(){
        DepartmentExample example =new DepartmentExample();
        List<Department> all = departmentService.getAll(example);
        for (Department department : all) {
            System.out.println(department);
        }
    }
}
