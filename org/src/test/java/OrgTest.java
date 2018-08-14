import cn.gezhi.crm.org.dao.EmployeeMapper;
import cn.gezhi.crm.org.entity.Employee;
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
    private EmployeeMapper employeeMapper;

    @Test
    public void test1() {
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        System.out.println(employee);
    }
    @Test
    public void test2(){
        Employee employee = employeeMapper.selectByPrimaryKey(2);
        System.out.println(employee);
    }
}
