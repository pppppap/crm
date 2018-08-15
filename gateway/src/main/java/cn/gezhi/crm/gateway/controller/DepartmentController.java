package cn.gezhi.crm.gateway.controller;

import cn.gezhi.crm.org.service.DepartmentService;
import cn.gezhi.crm.org.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * TODO
 *
 * @author Jo
 * @date 2018/8/15
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


}
