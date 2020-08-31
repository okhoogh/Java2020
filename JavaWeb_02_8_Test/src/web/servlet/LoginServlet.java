package web.servlet;

import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");

        // 2.验证码校验
        // 2.1获取用户输入验证码
        String verifycode = request.getParameter("verifycode");
        // 2.2获取系统生成验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        // 确保验证码一次使用
        session.removeAttribute("CHECKCODE_SERVER");
        // 2.3 验证码不正确
        if(checkcode_server != null && !checkcode_server.equalsIgnoreCase(verifycode)) {
            // 提示信息
            request.setAttribute("login_error", "验证码输入错误！！！");
            // 跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        // 3.获取数据
        Map<String, String[]> map = request.getParameterMap();
        // 4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 5.调用Service查询
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        // 6.判断用户是否存在
        if(loginUser != null) {
            // 登录成功，将用户存入session
            session.setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            // 提示信息
            request.setAttribute("login_error", "用户名或密码错误！！！");
            // 跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
