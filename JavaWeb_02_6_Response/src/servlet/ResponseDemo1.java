package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 重定向
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 访问/responseDemo1会自动跳转到/responseDemo2资源
        System.out.println("/responseDemo1被访问");
//        // 1.设置状态码302
//        response.setStatus(302);
//        // 2.设置响应头
//        response.setHeader("location", "/day15/responseDemo2");
        // 简化做法
//        response.sendRedirect("/day15/responseDemo2");
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/responseDemo2");
//        response.sendRedirect("https://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
