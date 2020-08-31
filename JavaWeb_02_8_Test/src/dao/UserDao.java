package dao;

import entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    /**
     * 查询所有用户信息(通过用户名和密码)
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

    /**
     * 添加用户信息(通过用户名和密码)
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 删除用户信息(通过用户id)
     * @param id
     * @return
     */
    void deleteUser(int id);

    /**
     * 查找用户信息(通过用户id)
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据条件查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据条件分页查询每条记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findUserByPage(int start, int rows, Map<String, String[]> condition);
}
