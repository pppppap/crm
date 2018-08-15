import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.EmployeeExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import cn.gezhi.crm.org.service.EmployeeService;
import cn.gezhi.crm.org.service.impl.CareerSericeImpl;
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
    @Autowired
    private CareerService careerService;

    @Test
    public void test1() {
        PageModel<Employee> pageModel = employeeService.getEmployeePage(1, 3);
        System.out.println(pageModel);
        System.out.println(pageModel.getTotalCount());
        System.out.println(pageModel.getCurrentPage());
        for (Employee employee : pageModel.getList()) {
            System.out.println(employee);
        }
    }

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


    @Test  //遍历表中数据，一页五个
    public  void test3(){
        PageModel<Career>  pageModel = careerService.getCareerPage(1,5);
        System.out.println(pageModel);
        System.out.println(pageModel.getTotalCount());
        System.out.println(pageModel.getCurrentPage());
        for (Career career : pageModel.getList()){
            System.out.println(career);
        }
    }

    @Test  //添加数据
    public void test4(){
        Career career = new Career();
        career.setId(5);
        career.setCareerName("boss");
        career.setCareerDesc("大boss");
        int n =careerService.save(career);
        System.out.println(n);
    }
}
