package servlet.test;


import org.junit.Test;
import servlet.dao.UserDao;
import servlet.entity.User;

public class UserDaoTest {

    @Test
    public void testLogin() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");
        System.out.println(userDao.login(user));
    }
}
