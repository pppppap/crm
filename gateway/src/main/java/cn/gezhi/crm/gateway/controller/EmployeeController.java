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
import java.util.HashMap;
import java.util.Map;


/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-15
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private static final int PAGESIZE = 5;

    @RequestMapping("/show")
    public String showCareer(Model model) {
        PageModel<Employee> pageModel = employeeService.getEmployeePage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "employees";
    }

    @RequestMapping(value = "/delete_employee", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete_employee(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
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



    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request, Model model) {
        String searchType = request.getParameter("search_type").trim();
        int page = Integer.parseInt(request.getParameter("page"));
        String key = request.getParameter("key").trim();

        PageModel<Employee> pageModel = employeeService.getByKeyPage(page, PAGESIZE, searchType, key);
        model.addAttribute("page", pageModel);
        return "employees";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter(HttpServletRequest request, Model model) {
        String sex = request.getParameter("sex");
        String department = request.getParameter("department_id");
        String age1 = request.getParameter("age1");
        String age2 = request.getParameter("age2");
        int page = Integer.parseInt(request.getParameter("page"));

        Map<String, String> map = new HashMap<String, String>();

        if (!sex.equals("0")) {
            map.put("sex", sex);
            model.addAttribute("sex", sex);
        }
        if (!department.equals("0")) {
            map.put("department_id", department);
            model.addAttribute("department_id", department);
        }
        if (!age1.equals("0") && !age2.equals("0")) {
            map.put("age1", age1);
            map.put("age2", age2);
            model.addAttribute("age1", age1);
            model.addAttribute("age2", age2);
        }

        PageModel<Employee> pageModel = employeeService.getByFilterPage(page, PAGESIZE, map);
        model.addAttribute("page", pageModel);


        return "employees";
    }
}