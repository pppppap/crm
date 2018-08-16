package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
public class CareerController {
    @Autowired
    private CareerService careerService;
    private static final int PAGESIZE = 20;

    @RequestMapping("show_career")
    public String showCareer(Model model) {
        PageModel<Career> pageModel = careerService.getCareerPage(1, PAGESIZE);
        model.addAttribute("page", pageModel);
        return "career";
    }

    //删除
    @RequestMapping(value = "/delete_career", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete_career(HttpServletRequest request) {
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

    //添加
    @RequestMapping("/addCareer")
    public String saveCareer(){
        return "addCareer";
    }

    @RequestMapping(value = "/add_career", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult add_career(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer id = Integer.parseInt(request.getParameter("career_id"));
        String career_name = request.getParameter("career_name");
        String career_desc = request.getParameter("career_desc");
        int n = careerService.save(new Career(id,career_name,career_desc));
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("添加成功！");
        } else {
            result.setCode(404);
            result.setMsg("添加失败！");
        }
        return result;
    }
    //更改
    @RequestMapping("/updateCareer")
    public String updateCareer(){
        return "updateCareer";
    }
    @RequestMapping(value = "/update_career",method =RequestMethod.POST )
    @ResponseBody
    public JsonResult update_career(HttpServletRequest request){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer id = Integer.parseInt(request.getParameter("career_id"));
        String career_name = request.getParameter("career_name");
        String career_desc = request.getParameter("career_desc");
        int n = careerService.update(new Career(id,career_name,career_desc));
        System.out.println(id);
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