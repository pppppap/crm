package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.dto.EmployeeDTO;
import cn.gezhi.crm.org.dto.UserDTO;
import cn.gezhi.crm.org.entity.*;
import cn.gezhi.crm.org.service.EmployeeService;
import cn.gezhi.crm.org.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/15
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    private static final int PAGESIZE = 10;

    @RequestMapping(value = "/show_user")
    public String show_user(Model model) {
        PageModel<UserDTO> pageModel = userService.getUserPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(HttpServletRequest request, Model model) {
        int page = Integer.parseInt(request.getParameter("page"));
        PageModel<UserDTO> pageModel = userService.getUserPage(page, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, @RequestParam int id, @RequestParam String username) {
        request.setAttribute("userId", id);
        request.setAttribute("username", username);
        return "updateUser";
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update_user(HttpServletRequest request) {
        int n = 0;
        JsonResult result = new JsonResult();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String empName = request.getParameter("empName");
        if (StringUtils.isBlank(empName)) {
            if (StringUtils.isBlank(password)) {
                result.setMsg("无任何修改");
                return result;
            } else {
                n = userService.update(new User(id, username, password));
            }
        } else if (StringUtils.isNotBlank(empName)) {
            EmployeeExample employeeExample = new EmployeeExample();
            EmployeeExample.Criteria criteria = employeeExample.createCriteria();
            criteria.andNameEqualTo(empName);
            List<EmployeeDTO> employeeDTOS = employeeService.getByExample(employeeExample);
            if (employeeDTOS != null && !employeeDTOS.isEmpty()) {
                for (EmployeeDTO employee : employeeDTOS) {
                    Integer empId = employee.getId();
                    if (StringUtils.isBlank(password)) {
                        n = userService.update(new User(id, username, empId));
                    } else {
                        n = userService.update(new User(id, username, password, empId));
                    }
                }
            } else {
                result.setMsg("该员工不存在");
                return result;
            }
        }
        if (n > 0) {
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(404);
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add_user(HttpServletRequest request) {
        int n = 0;
        JsonResult result = new JsonResult();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String empName = request.getParameter("empName");
        UserExample userExample1 = new UserExample();
        UserExample.Criteria userExampleCriteria1 = userExample1.createCriteria();
        userExampleCriteria1.andUsernameEqualTo(username);
        List<UserDTO> userDTOS1 = userService.getByExample(userExample1);
        if (userDTOS1.size() == 0) {
            EmployeeExample employeeExample = new EmployeeExample();
            EmployeeExample.Criteria employeeExampleCriteria = employeeExample.createCriteria();
            employeeExampleCriteria.andNameEqualTo(empName);
            List<EmployeeDTO> employeeDTOS = employeeService.getByExample(employeeExample);
            if (employeeDTOS.size() == 1) {
                for (EmployeeDTO employee : employeeDTOS) {
                    Integer empId = employee.getId();
                    UserExample userExample2 = new UserExample();
                    UserExample.Criteria userExampleCriteria2 = userExample2.createCriteria();
                    userExampleCriteria2.andEmployeeIdEqualTo(empId);
                    List<UserDTO> userDTOS2 = userService.getByExample(userExample2);
                    if (userDTOS2.size() == 0) {
                        n = userService.save(new User(username, password, empId));
                        if (n > 0) {
                            result.setCode(200);
                            result.setMsg("新增成功");
                        } else {
                            result.setCode(404);
                            result.setMsg("新增失败");
                        }
                    } else {
                        result.setCode(404);
                        result.setMsg("已存在该员工的用户");
                        return result;
                    }
                }
            } else if (employeeDTOS.size() == 0) {
                result.setCode(404);
                result.setMsg("该员工不存在");
                return result;
            }
        } else {
            result.setCode(404);
            result.setMsg("该用户名已存在");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete_user(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        int n = userService.deleteById(id);
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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(HttpServletRequest request, Model model) {
        PageModel<UserDTO> pageMode = new PageModel<UserDTO>();
        String searchType = request.getParameter("search_type");
        String p = request.getParameter("page");
        int page = 1;
        if (StringUtils.isNotBlank(p)) {
            page = Integer.parseInt(p);
        }
        String key = request.getParameter("key");
        UserExample userExample = new UserExample();
        if (StringUtils.isNotBlank(key)) {
            UserExample.Criteria criteria = userExample.createCriteria();
            if (searchType.equals("1")) {
                criteria.andUsernameLike(key);
                pageMode = userService.getByExamplePage(page, PAGESIZE, userExample);
                model.addAttribute("page", pageMode);
                return "showUser";
            } else if (searchType.equals("2")) {
                EmployeeExample employeeExample = new EmployeeExample();
                EmployeeExample.Criteria employeeExampleCriteria = employeeExample.createCriteria();
                employeeExampleCriteria.andNameEqualTo(key);
                List<EmployeeDTO> employeeDTOS = employeeService.getByExample(employeeExample);
                Integer empId;
                if (employeeDTOS.size() == 1) {
                    for (EmployeeDTO employee : employeeDTOS) {
                        empId = employee.getId();
                        criteria.andEmployeeIdEqualTo(empId);
                        pageMode = userService.getByExamplePage(page, PAGESIZE, userExample);
                        model.addAttribute("page", pageMode);
                        return "showUser";
                    }
                }else {
                    criteria.andPasswordEqualTo(key);
                    pageMode = userService.getByExamplePage(page, PAGESIZE, userExample);
                    model.addAttribute("page", pageMode);
                    return "showUser";
                }
            }
        }
        pageMode = userService.getUserPage(1, PAGESIZE);
        model.addAttribute("page", pageMode);
        return "showUser";
    }
}