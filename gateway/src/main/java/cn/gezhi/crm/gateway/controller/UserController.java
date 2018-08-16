package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.Employee;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.entity.User;
import cn.gezhi.crm.org.service.UserService;
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
 * @author jinlu
 * @date 2018/8/15
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static final int PAGESIZE = 10;

    @RequestMapping(value = "/show_user")
    public String show_user(Model model) {
        PageModel<User> pageModel = userService.getUserPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(HttpServletRequest request, Model model) {
        int page = Integer.parseInt(request.getParameter("page"));
        PageModel<User> pageModel = userService.getUserPage(page, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request, @RequestParam int id,@RequestParam String username) {
        request.setAttribute("userId",id);
        request.setAttribute("username",username);
        return "updateUser";
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update_user(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer empId = Integer.parseInt(request.getParameter("empId"));
        int n = userService.update(new User(id, username, password, empId));
        JsonResult result = new JsonResult();
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer empId = Integer.parseInt(request.getParameter("empId"));
        int n = userService.save(new User(username, password, empId));
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("新增成功");
        } else {
            result.setCode(404);
            result.setMsg("新增失败");
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
}