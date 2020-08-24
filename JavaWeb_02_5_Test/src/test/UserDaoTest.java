package test;

import dao.UserDao;
import entity.User;
import org.junit.Test;

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
