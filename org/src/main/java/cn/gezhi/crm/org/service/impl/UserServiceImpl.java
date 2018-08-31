package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.UserMapper;
import cn.gezhi.crm.org.dto.EmployeeDTO;
import cn.gezhi.crm.org.dto.UserDTO;
import cn.gezhi.crm.org.entity.*;
import cn.gezhi.crm.org.service.EmployeeService;
import cn.gezhi.crm.org.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户功能类
 *
 * @author jinlu
 * @date 2018/8/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 根据ID查询用户
     *
     * @param id 用户的ID
     * @return 一个用户的对象
     **/
    public UserDTO getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<UserDTO> getByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    /**
     * 根据ID更新用户
     *
     * @param user 一个用户的对象
     * @return 受影响的行数
     **/
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 新增一个用户
     *
     * @param user 一个用户的对象
     * @return 受影响的行数
     **/
    public int save(User user) {
        return userMapper.insert(user);
    }

    /**
     * 根据ID删除用户
     *
     * @param id 用户的ID
     * @return 受影响的行数
     **/
    public int deleteById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询用户并分页显示
     *
     * @param page 显示当前页面 pageSize 页面显示数目
     * @return 一个包含用户的page分页模型
     **/
    public PageModel<UserDTO> getUserPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id");
        List<UserDTO> users = userMapper.selectByExample(userExample);
        PageModel<UserDTO> pageModel = new PageModel<UserDTO>(users);
        return pageModel;
    }

    public PageModel<UserDTO> getByExamplePage(int page, int pageSize, UserExample example) {
        PageHelper.startPage(page, pageSize);
        List<UserDTO> userDTOS = userMapper.selectByExample(example);
        return new PageModel<UserDTO>(userDTOS);
    }

    public UserDTO login(String username, String password) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username.trim());
        criteria.andPasswordEqualTo(password.trim());
        List<UserDTO> userDTOS = userMapper.selectByExample(example);
        if (userDTOS.isEmpty()) return null;
        return userDTOS.get(0);
    }
}