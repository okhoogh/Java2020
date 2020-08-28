package servlet;

import servlet.dao.UserDao;
import servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");
        // 2.获取参数
        String checkCode = request.getParameter("checkCode");
        // 3.判断验证码是否输入正确
        // 3.1先获取生成的验证码
        String checkCode_session = (String) request.getSession().getAttribute("checkCode_session");
        // 3.2获取了就删除，以免下次还是用这个
        request.getSession().removeAttribute("checkCode_session");
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            User loginUser = new User();
            loginUser.setUsername(request.getParameter("username"));
            loginUser.setPassword(request.getParameter("password"));
            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);
            if(user != null) {
                // 登陆成功
                // 存储用户信息
                request.getSession().setAttribute("username", user.getUsername());
                // 重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // 登陆失败
                request.setAttribute("login_error", "用户名或密码错误！！！");
                // 转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            System.out.println(checkCode + " " + checkCode_session);
            request.setAttribute("cc_error", "验证码错误！！！");
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
