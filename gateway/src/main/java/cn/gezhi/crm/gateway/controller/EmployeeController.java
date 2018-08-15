package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/delete_employee", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult delete_employee(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int n = employeeService.delete(id);
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("删除成功");
        } else {
            result.setCode(404);
            result.setMsg("删除失败");
        }
        return result;
    }
}
