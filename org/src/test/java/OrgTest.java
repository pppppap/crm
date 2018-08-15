import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 *
 * @author pppppap
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-placeholder.xml", "classpath:spring/application*.xml"})
public class OrgTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    public void test1() {
        PageModel<Employee> pageModel = employeeService.getEmployeePage(1, 2);
        System.out.println(pageModel);
        System.out.println(pageModel.getTotalCount());
        System.out.println(pageModel.getCurrentPage());
        for(Employee employee:pageModel.getList()){
            System.out.println(employee);
        }
    }
}
