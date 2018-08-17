package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.CareerExample;
import cn.gezhi.crm.org.entity.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *TODO
 *
 *@author chenxianbin
 *@date 2018/8/15
 */

public interface CareerService {
    PageModel<Career> getCareerPage(int page, int pageSize);
    List<Career> getByExample(CareerExample example);
    PageModel<Career> getByExamplePage(int page, int pageSize, CareerExample example);


    Career getById(int id);  //id查询
    int  update (Career career);  //更新
    int  save (Career career);   //新增插入
    int  deleteById(int id);  //删除



}
