package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author chenxianbin
 * @date 2018/8/15
 */
@Controller
public class CareerController {
    @Autowired
    private CareerService  careerService;
    private  static final int PAGESIZE = 5;

    @RequestMapping("show_career")
    public String showCareer(Model model) {
        PageModel<Career> pageModel = careerService.getCareerPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "employees";
    }
}
