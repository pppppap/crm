package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.dto.UserDTO;
import cn.gezhi.crm.org.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-31
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/do_login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (StringUtils.isNoneBlank(username) && StringUtils.isNoneBlank(password)) {
            UserDTO user = userService.login(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                return "redirect:/index";
            }
        }
        model.addAttribute("msg", "登录失败");
        return "login";
    }
}
