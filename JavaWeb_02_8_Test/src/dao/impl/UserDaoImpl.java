package dao.impl;

import dao.UserDao;
import entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        // 1.定义sql
        String sql = "select * from user";
        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        // 1.定义sql
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, null, null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(),
                        user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        try {
            template.update(sql, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail()
        , user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 1.定义模板sql
        String sql = "select count(*) from user where 1 = 1";
        // 2.遍历condition
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key))
                continue;
            // 判断value是否有值
            if (value != null && !value.equals("")) {
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        sql = sb.toString();

//        System.out.println(sb.toString());
//        System.out.println(template.queryForObject(sb.toString(), Integer.class, values.toArray()));
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<User> findUserByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        // 2.遍历condition
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keys = condition.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keys) {
            String value = condition.get(key)[0];
            if("currentPage".equals(key) || "rows".equals(key))
                continue;
            // 判断value是否有值
            if (value != null && !value.equals("")) {
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        sb.append(" limit ?, ?");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
//        System.out.println(sql);

        List<User> users = null;
        try {
            users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return users;
    }
}
