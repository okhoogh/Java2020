package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.PageBean;
import entity.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        // 调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteSelectedUser(String[] uids) {
        for (String uid : uids) {
            dao.deleteUser(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String s_currentPage, String s_rows, Map<String, String[]> condition) {
        // 1.创建空的PageBean
        PageBean<User> pb = new PageBean<User>();
        // 2.设置参数
        if(s_currentPage == null || s_currentPage.equals(""))
            s_currentPage = "1";
        if(s_rows == null || s_rows.equals(""))
            s_rows = "5";
        int currentPage = Integer.parseInt(s_currentPage);
        int rows = Integer.parseInt(s_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        // 3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 4.调用dao查询list集合
        int start = (currentPage - 1) * rows;
        List<User> users = dao.findUserByPage(start, rows, condition);
        pb.setList(users);
        // 5.计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
