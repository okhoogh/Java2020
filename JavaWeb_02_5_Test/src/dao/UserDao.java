package dao;

import entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class UserDao {
    // 声明JDBCTemplate对象共用
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return user包含全部信息
     */
    public User login(User loginUser) {
        // 1.编写sql
        String sql = "select * from user where username = ? and password = ?";
        // 2.调用queryForObject方法生成对象
        User user = null;
        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
