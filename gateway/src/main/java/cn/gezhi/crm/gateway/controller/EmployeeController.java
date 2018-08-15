package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-15
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private static final int PAGESIZE = 5;

    @RequestMapping("/show_employee")
    public String showCareer(Model model) {
        PageModel<Employee> pageModel = employeeService.getEmployeePage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "employees";
    }
}
