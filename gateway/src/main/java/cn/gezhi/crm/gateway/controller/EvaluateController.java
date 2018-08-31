package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.customer.dao.BankMapper;
import cn.gezhi.crm.customer.dto.CustomerQueryDTO;
import cn.gezhi.crm.customer.entity.Car;
import cn.gezhi.crm.customer.entity.Customer;
import cn.gezhi.crm.customer.entity.House;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;
import cn.gezhi.crm.customer.service.EvaluateService;
import cn.gezhi.crm.gateway.dto.JsonResult;
import cn.gezhi.crm.org.entity.PageModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author pppppap
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
    private static final int PAGE_SIZE = 15;

    @Autowired
    private EvaluateService evaluateService;
    @Autowired
    private BankMapper bankMapper;

    @RequestMapping("/show")
    public String show(HttpServletRequest request, Model model) {
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
        }
        PageModel<CustomerCustom> customerPage = evaluateService.getCustomerPage(page, PAGE_SIZE);

        model.addAttribute("banks", bankMapper.selectByExample(null));
        model.addAttribute("page", customerPage);
        return "customer";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public String filter(HttpServletRequest request, Model model) {
        int page = 1;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }

        String uri = "";
        CustomerQueryDTO queryDTO = new CustomerQueryDTO();
        String key = request.getParameter("key");
        if (StringUtils.isNotBlank(key)) {
            int searchType = Integer.parseInt(request.getParameter("searchType"));
            switch (searchType) {
                case 1:
                    queryDTO.setName(key);
                    break;
                case 2:
                    queryDTO.setIdcard(key);
                    break;
                case 3:
                    queryDTO.setTel(key);
                    break;
                default:
                    break;
            }
            queryDTO.setSearchType(request.getParameter("searchType"));
            model.addAttribute("key", key);
            uri = "searchType=" + searchType + "&key=" + key;
        } else {
            String attentionLevel = StringUtils.defaultString(request.getParameter("attentionLevel"), "0");
            if (!"0".equals(attentionLevel))
                queryDTO.setAttentionLevel(attentionLevel);

            String customerLevel = StringUtils.defaultString(request.getParameter("customerLevel"), "0");
            if (!"0".equals(customerLevel))
                queryDTO.setCustomerLevel(customerLevel);

            String bankId = StringUtils.defaultString(request.getParameter("bankId"), "0");
            if (bankId != null && !"0".equals(bankId))
                queryDTO.setBankId(Integer.parseInt(bankId));

            String process = StringUtils.defaultString(request.getParameter("process"), "0");
            if (!"0".equals(process))
                queryDTO.setProcess(process);
            uri = "attentionLevel=" + attentionLevel + "&customerLevel=" + customerLevel + "&bankId=" + bankId + "&process=" + process;
        }


        queryDTO.page = page;
        queryDTO.pageSize = PAGE_SIZE;


        PageModel<CustomerCustom> customerPage = evaluateService.getCustomerPage(queryDTO);
        customerPage.setUrl(uri);
        model.addAttribute("banks", bankMapper.selectByExample(null));
        model.addAttribute("page", customerPage);
        model.addAttribute("queryDTO", queryDTO);
        return "customer";
    }

    @RequestMapping("/getOne/{id}")
    public String getOne(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        model.addAttribute("customer", evaluateService.getById(id));
        model.addAttribute("back_uri", request.getHeader("Referer"));
        return "customer_info";

    }

    @RequestMapping("/do_update")
    @ResponseBody
    public JsonResult doUpdate(Customer customer) {
        int n = evaluateService.update(customer);
        JsonResult result = new JsonResult();
        if (n > 0) {
            result.setCode(200);
            result.setMsg("更新成功");
        } else {
            result.setCode(404);
            result.setMsg("更新失败");
        }
        return result;
    }

    @RequestMapping(value = "/upload_house/{id}")
    public String uploadHouse(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("houses", evaluateService.getHouses(id));
        return "upload_house";
    }

    @RequestMapping(value = "/do_upload_house", method = RequestMethod.POST)
    @ResponseBody
    public void uploadHouse(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            String ids = request.getParameter("uid");
            if (ids == null) return;
            int id = Integer.parseInt(ids);
            String path = request.getSession().getServletContext().getRealPath("static/data/house/");//设置磁盘缓冲路径
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (!file.isEmpty()) {
                    try {
                        String name = saveFile(file, path);
                        House house = new House();
                        house.setCustomerId(id);
                        house.setUri("/data/house/" + name);
                        evaluateService.saveHouse(house);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/upload_car/{id}")
    public String uploadCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("cars", evaluateService.getCar(id));
        return "upload_car";
    }

    @RequestMapping(value = "/do_upload_car", method = RequestMethod.POST)
    @ResponseBody
    public void uploadCar(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            String ids = request.getParameter("uid");
            if (ids == null) return;
            int id = Integer.parseInt(ids);
            String path = request.getSession().getServletContext().getRealPath("static/data/car/");//设置磁盘缓冲路径
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                if (!file.isEmpty()) {
                    try {
                        String name = saveFile(file, path);
                        Car car = new Car();
                        car.setCustomerId(id);
                        car.setUri("/data/car/" + name);
                        evaluateService.saveCar(car);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String saveFile(MultipartFile file, String path) throws IOException {
        String fileName = file.getOriginalFilename();//真实文件名
        int index = fileName.lastIndexOf(".");
        String type = fileName.substring(index + 1);
        String name = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + ((int) (Math.random() * 9000) + 1000) + "." + type;
        File filepath = new File(path);
        if (!filepath.exists())
            filepath.mkdirs();
        // 文件保存路径
        String savePath = path + name;
        // 转存文件
        file.transferTo(new File(savePath));
        return name;
    }

}
