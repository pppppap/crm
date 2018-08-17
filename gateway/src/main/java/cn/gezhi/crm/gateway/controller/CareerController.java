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
    private static final int PAGESIZE = 3;
    private int careerId;

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

    @RequestMapping("/careerId")
    public  String careerId(HttpServletRequest request){
        this.careerId = Integer.parseInt(request.getParameter("careerId"));
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
        String career_name = request.getParameter("career_name");
        String career_desc = request.getParameter("career_desc");
        int n = careerService.update(new Career(careerId,career_name,career_desc));
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

    //分页
    @RequestMapping(value = "/career", method = RequestMethod.GET)
    public String search(HttpServletRequest request, Model model) {
        int  page = Integer.parseInt(request.getParameter("page"));
        PageModel<Career> pageModel = careerService.getCareerPage(page,PAGESIZE);
        model.addAttribute("page",pageModel);
          return "career";
    }

}