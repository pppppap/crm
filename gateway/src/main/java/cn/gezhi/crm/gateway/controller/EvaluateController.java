package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.customer.dao.BankMapper;
import cn.gezhi.crm.customer.dto.CustomerQueryDTO;
import cn.gezhi.crm.customer.entity.vo.CustomerCustom;
import cn.gezhi.crm.customer.service.EvaluateService;
import cn.gezhi.crm.org.entity.PageModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @author pppppap
 */
@Controller
@RequestMapping("/evaluate")
public class EvaluateController {
    private static final int PAGE_SIZE = 10;

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
    public String getOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", evaluateService.getById(id));
        return "customer_info";

    }
}
