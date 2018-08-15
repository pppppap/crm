package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.entity.User;
import cn.gezhi.crm.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private static final int PAGESIZE = 5;
    @RequestMapping("/show_user")
    public String showCareer(Model model) {
        PageModel<User> pageModel = userService.getUserPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "showUser";
    }

    @RequestMapping("/add_user")
    public String addUser() {
        return "addUser";
    }
}