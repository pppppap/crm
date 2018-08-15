package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.entity.Department;
import cn.gezhi.crm.org.entity.DepartmentExample;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.DepartmentService;
import cn.gezhi.crm.org.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/15
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private static final int PAGESIZE = 5;

    @RequestMapping("/show_department")
    public String showDepartment(Model model){
        PageModel<Department> pageModel = departmentService.getDepartmentPage(1, PAGESIZE);
        model.addAttribute("page",pageModel);
        System.out.println("请求");
        return "department";
    }
}
