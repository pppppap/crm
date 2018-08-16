import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.impl.DepartmentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-placeholder.xml", "classpath:spring/application*.xml"})
public class OrgTest {
@Autowired
    DepartmentServiceImpl departmentService;
    @Test
    public void test1() {
        PageModel<Department> page = departmentService.getByExamplePage(1, 3, null);
        System.out.println(page.getList());
    }


}

