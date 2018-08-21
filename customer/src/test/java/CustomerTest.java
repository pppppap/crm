import cn.gezhi.crm.customer.service.EvaluteService;
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
public class CustomerTest {
    @Autowired
    private EvaluteService evaluteService;
    @Test
    public void test1() {
        System.out.println(evaluteService.getByEvaluteId(2));
    }
}