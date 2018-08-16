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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/15
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private static final int PAGESIZE = 5;

    @RequestMapping("/show")
    public String showDepartment(HttpServletRequest request,Model model) {
        String s = request.getParameter("page");
        int page =1;
        if (s!=null) {
            page = Integer.parseInt(s);
        }
        PageModel<Department> pageModel = departmentService.getDepartmentPage(page, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "department";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
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

    @RequestMapping("/adddepartment")
    public String adddepartment() {
        return "adddepartment";
    }

    @RequestMapping("/updatedepartment")
    public String updateDepartment(HttpServletRequest request, Model model) {
        int i = Integer.parseInt(request.getParameter("id"));
        Department department = departmentService.getOne(i);
        model.addAttribute("department", department);
        return "updatedepartment";

    }

    @RequestMapping("/submitupdation")
    public String submit_updation(Department department) {
        Integer id = department.getId();
        String depName = department.getDepName();
        String depDesc = department.getDepDesc();
        departmentService.updateSelective(department);
        return "forward:/department/show";
    }

    @RequestMapping("/add")
    public String add_department(Department department) {
        Integer id = department.getId();
        String depName = department.getDepName();
        String depDesc = department.getDepDesc();
        System.out.println(depName);
        System.out.println(depDesc);
        departmentService.saveSelective(department);
        return "forward:/department/show";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(HttpServletRequest request, Model model) {
        String searchType = request.getParameter("search_type");
        String s = request.getParameter("page");
        int page =1;
        if (s!=null) {
             page = Integer.parseInt(s);
        }
        String key = request.getParameter("key").trim();

        PageModel<Department> pageModel = departmentService.getByKeyPage(page, PAGESIZE, searchType, key);
        model.addAttribute("page", pageModel);

        return "department";
    }
}
