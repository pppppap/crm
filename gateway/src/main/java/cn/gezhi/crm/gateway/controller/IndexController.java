package cn.gezhi.crm.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author pppppap
 * @date 2018-08-15
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String main() {
        return "main";
    }

    @RequestMapping("/left")
    public String left() {
        return "left";
    }

    @RequestMapping("/right")
    public String right() {
        return "right";
    }

    @RequestMapping("/top")
    public String top() {
        return "top";
    }
}