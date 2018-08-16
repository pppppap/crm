package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.entity.User;
import cn.gezhi.crm.org.service.UserService;
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
 * @author jinlu
 * @date 2018/8/15
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private static final int PAGESIZE = 10;
    private int userId;

    @RequestMapping(value = "/show_user")
    public String show_user(Model model) {
        PageModel<User> pageModel = userService.getUserPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser() {
        return "updateUser";
    }

    @RequestMapping(value = "/get_id", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult get_id(HttpServletRequest request) {
        this.userId = Integer.parseInt(request.getParameter("id"));
        JsonResult result = new JsonResult();
        return result;
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update_user(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Integer empId = Integer.parseInt(request.getParameter("empId"));
        int n = userService.update(new User(userId, username, password, empId));
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