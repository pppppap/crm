package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.CareerMapper;
import cn.gezhi.crm.org.entity.Career;
import cn.gezhi.crm.org.entity.CareerExample;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.service.CareerService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author chenxianbin
 * @date 2018/8/15
 */
@Service
public class CareerSericeImpl implements CareerService {
    @Autowired
    private CareerMapper careerMapper;

    public PageModel<Career> getCareerPage(int page, int pageSize) {
        return getByExamplePage(page, pageSize,null);
    }

    public List<Career> getByExample(CareerExample example) {
        return careerMapper.selectByExample(example);
    }

    public PageModel<Career> getByExamplePage(int page, int pageSize, CareerExample example) {
        PageHelper.startPage(page, pageSize);
        List<Career> employees = careerMapper.selectByExample(example);
        return new PageModel<Career>(employees);
    }

    public Career getById(int id) {
        return careerMapper.selectByPrimaryKey(id);
    }

    public Integer update(Career career) {
        return careerMapper.updateByPrimaryKey(career);
    }

    public Integer save(Career career) {
        return careerMapper.insert(career);
    }

    public Integer deleteById(int id) {
        return careerMapper.deleteByPrimaryKey(id);
    }


}
