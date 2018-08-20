package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.dto.EmployeeDTO;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import cn.gezhi.crm.org.service.DepartmentService;
import cn.gezhi.crm.org.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CareerService careerService;
    private static final int PAGESIZE = 15;

    @RequestMapping("/show")
    public String showCareer(HttpSession session, Model model) {
        PageModel<EmployeeDTO> pageModel = employeeService.getEmployeePage(1, PAGESIZE);

        model.addAttribute("page", pageModel);

        session.setAttribute("departments", departmentService.getAll(null));
        session.setAttribute("careers", careerService.getByExample(null));
        return "employees";
    }

    @RequestMapping("/do_add")
    @ResponseBody
    public JsonResult add(Employee employee) {
        JsonResult result = new JsonResult();
        int n = employeeService.save(employee);
        if (n > 0) {
            result.setCode(200);
            result.setMsg("保存成功");
        } else {
            result.setCode(404);
            result.setMsg("保存失败");
        }
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
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
        String searchType = request.getParameter("search_type");
        String p = request.getParameter("page");
        int page = 1;
        if (StringUtils.isNotBlank(p))
            page = Integer.parseInt(p);
        String key = request.getParameter("key");

        PageModel<EmployeeDTO> pageModel = employeeService.getByKeyPage(page, PAGESIZE, searchType, key);
        model.addAttribute("page", pageModel);

        return "employees";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter(HttpServletRequest request, Model model) {
        String sex = request.getParameter("sex");
        sex = sex == null ? "0" : sex;
        String department = request.getParameter("dep_id");
        department = department == null ? "0" : department;
        String age1 = request.getParameter("age1");
        String age2 = request.getParameter("age2");
        age1 = age1 == null ? "0" : age1;
        age2 = age2 == null ? "0" : age2;
        String p = request.getParameter("page");
        int page = p == null ? 1 : Integer.parseInt(p);

        String uri = "sex=" + sex + "&dep_id=" + department + "&age1=" + age1 + "&age2=" + age2;

        Map<String, String> map = new HashMap<String, String>();

        if (!sex.equals("0")) {
            map.put("sex", sex);
        }
        model.addAttribute("sex", sex);

        if (!department.equals("0")) {
            map.put("dep_id", department);
        }
        model.addAttribute("dep_id", department);

        if (!age1.equals("0") && !age2.equals("0")) {
            map.put("age1", age1);
            map.put("age2", age2);
            model.addAttribute("age1", age1);
            model.addAttribute("age2", age2);
        } else if (age1.equals("0") && age2.equals("0")) {
            model.addAttribute("age1", age1);
            model.addAttribute("age2", age2);
        }

        PageModel<EmployeeDTO> pageModel = employeeService.getByFilterPage(page, PAGESIZE, map);

        pageModel.setUrl(uri);
        model.addAttribute("page", pageModel);
        return "employees";
    }

    @RequestMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        String ids = request.getParameter("id");
        model.addAttribute("back_uri",  request.getHeader("Referer"));
        if (StringUtils.isNotBlank(ids)) {
            int id = Integer.parseInt(ids);
            EmployeeDTO employeeDTO = employeeService.getById(id);
            model.addAttribute("employee", employeeDTO);
        }
        model.addAttribute("departments", departmentService.getAll(null));
        model.addAttribute("careers", careerService.getByExample(null));
        return "updateEmployee";
    }

    @RequestMapping(value = "/do_update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult do_update(Employee employee) {
        JsonResult result = new JsonResult();
        int n = employeeService.update(employee);
        if (n > 0) {
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(404);
            result.setMsg("修改失败");
        }
        return result;
    }
}

