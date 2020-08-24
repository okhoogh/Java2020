package Servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class successServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 给页面输出一句话
        // 设置编码
        response.setContentType("text/html; charset=utf-8");
        // 获取request域中共享的user对象
        User user = (User)request.getAttribute("user");
        // 输出
        if(user != null)
            response.getWriter().write("登录成功！用户名:" + user.getUsername() + ",欢迎您");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
