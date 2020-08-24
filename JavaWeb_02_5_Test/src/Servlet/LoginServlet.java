package Servlet;

import dao.UserDao;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");

        /*// 2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 3.封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        // 2.获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 3.创建User对象
        User loginUser = new User();
        // 3.1使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 4.调用UserDao的login
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        // 5.判断user
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/successServlet").forward(request, response);
        } else {
            request.getRequestDispatcher("/failServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
