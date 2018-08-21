package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * TODO
 *
 * @author chenxianbin
 * @date 2018/8/15
 */
@Controller
@RequestMapping("/career")
public class CareerController {
    @Autowired
    private CareerService careerService;
    private static final int PAGESIZE = 10;

    @RequestMapping("/show_career")
    public String showCareer(HttpServletRequest request, Model model) {
        String p = request.getParameter("page");
        int page = p == null ? 1 : Integer.parseInt(p);
        PageModel<Career> pageModel = careerService.getCareerPage(page, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "career";
    }

    //删除
    @RequestMapping(value = "/do_delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteCareer(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        int n = careerService.deleteById(id);
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("删除成功!");
        } else {
            result.setCode(404);
            result.setMsg("删除失败!");
        }
        return result;
    }


    @RequestMapping(value = "/do_add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult addCareer(Career career) {
        JsonResult result = new JsonResult();
        int n = careerService.save(career);
        if (n > 0) {
            result.setCode(200);
            result.setMsg("添加成功！");
        } else {
            result.setCode(404);
            result.setMsg("添加失败！");
        }
        return result;
    }

    @RequestMapping("/update_career")
    public String updateCareer(int id, Model model) {
        Career career = careerService.getById(id);
        model.addAttribute("career", career);
        return "updateCareer";
    }


    @RequestMapping(value = "/do_update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doUpdate(Career career) {
        int n = careerService.update(career);
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("修改成功！");
        } else {
            result.setCode(404);
            result.setMsg("修改失败！");
        }
        return result;
    }


}