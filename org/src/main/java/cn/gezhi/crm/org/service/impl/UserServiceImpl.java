package cn.gezhi.crm.org.service.impl;

import cn.gezhi.crm.org.dao.UserMapper;
import cn.gezhi.crm.org.entity.*;
import cn.gezhi.crm.org.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public int save(User user) {
        return userMapper.insert(user);
    }

    public int deleteById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    public PageModel<User> getUserPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id");
        List<User> users = userMapper.selectByExample(userExample);
        PageModel<User> pageModel = new PageModel<User>(users);
        return pageModel;
    }
}