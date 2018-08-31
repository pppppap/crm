package cn.gezhi.crm.org.service;

import cn.gezhi.crm.org.dto.UserDTO;
import cn.gezhi.crm.org.entity.PageModel;
import cn.gezhi.crm.org.entity.User;
import cn.gezhi.crm.org.entity.UserExample;

import java.util.List;

/**
 * TODO
 *
 * @author jinlu
 * @date 2018/8/15
 */
public interface UserService {
    UserDTO getById(int id);

    List<UserDTO> getByExample(UserExample userExample);

    int update(User user);

    int save(User user);

    int deleteById(int id);

    PageModel<UserDTO> getUserPage(int page, int pageSize);

    PageModel<UserDTO> getByExamplePage(int page, int pageSize, UserExample example);

    UserDTO login(String username, String password);
}