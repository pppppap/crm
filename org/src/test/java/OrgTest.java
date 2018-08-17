
import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.CareerExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import cn.gezhi.crm.org.service.impl.CareerSericeImpl;
import cn.gezhi.crm.org.service.impl.DepartmentServiceImpl;
import com.github.pagehelper.Page;

import cn.gezhi.crm.org.service.EmployeeService;

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
@ContextConfiguration(locations = {"classpath:spring-placeholder.xml", "classpath:spring/application*.xml"})
public class OrgTest {


    @Test
    public void test(){

    }


    @Autowired
    EmployeeService service;

    @Test
    public void test1() {
        System.out.println(service.getById(1));
    }



}

