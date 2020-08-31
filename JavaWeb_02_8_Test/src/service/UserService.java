package service;

import entity.PageBean;
import entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 查询用户信息通过id
     * @param id
     */
    User findUserById(String id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除选中用户
     * @param uids
     */
    void deleteSelectedUser(String[] uids);

    /**
     * 分页条件查询
     * @param s_currentPage
     * @param s_rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String s_currentPage, String s_rows, Map<String, String[]> condition);
}
