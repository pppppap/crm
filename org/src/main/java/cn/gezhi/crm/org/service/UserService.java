package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.entity.User;
/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/15
 */
public interface UserService {
    User getById(int id);
    int update(User user);
    int save(User user);
    int deleteById(int id);
    PageModel<User> getUserPage(int page, int pageSize);
}