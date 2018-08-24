import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.service.SalesmanService;
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
public class CustomerTest {
@Autowired
    private SalesmanService salesmanService;

    @Test
    public void test1() {
        List<Customer> salesman = salesmanService.getBySalesmanId(1);
        for (Customer customer : salesman) {
            System.out.println(customer);
        }
    }

}