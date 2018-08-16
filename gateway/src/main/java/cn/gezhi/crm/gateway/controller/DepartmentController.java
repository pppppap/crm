package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String showDepartment(Model model) {
        PageModel<Department> pageModel = departmentService.getDepartmentPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "department";
    }

    @RequestMapping(value = "/delete_department", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete_department(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int n = departmentService.deleteOne(id);
        JsonResult result = null;
        if (n > 0) {
            result = new JsonResult(200, "删除成功", null);
        } else {
            result = new JsonResult(404, "删除失败", null);
        }
        return result;
    }

    @RequestMapping("/add_department")
    public String add_department() {
        return "adddepartment";
    }

    @RequestMapping("/update_department")
    public String update_department(HttpServletRequest request, Model model) {
        int i = Integer.parseInt(request.getParameter("id"));
        System.out.println(i);
        Department department = departmentService.getOne(i);
        model.addAttribute("department", department);
        return "updatedepartment";

    }
}
