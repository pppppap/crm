import cn.gezhi.crm.customer.dto.CustomerQueryDTO;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;
import cn.gezhi.crm.customer.service.EvaluateService;
import cn.gezhi.crm.org.entity.PageModel;
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
    private EvaluateService evaluateService;

    @Test
    public void test1() {
        CustomerQueryDTO queryDTO=new CustomerQueryDTO();
        queryDTO.setProcess("已放款");
        queryDTO.setAttentionLevel("B");
        PageModel<CustomerCustom> customers = evaluateService.getCustomerPage(queryDTO);
        for (CustomerCustom customerCustom : customers.getList()) {


            System.out.println(customerCustom.getBank().getName());
            System.out.println(customerCustom.getCars());
            System.out.println(customerCustom.getEvaluteman().getName());
            System.out.println(customerCustom.getHouses());
            System.out.println(customerCustom.getSalesman().getName());
        }
    }

}