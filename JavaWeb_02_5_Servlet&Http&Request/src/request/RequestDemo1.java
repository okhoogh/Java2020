package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        // 2.获取虚拟目录: /day14
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        // 3.获取Servlet路径: /demo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
        // 4.获取Get请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);
        // 5.获取URI: /day14/demo1
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // 6.获取URL: http://loaclhost/day14/demo1
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL.toString());
        // 7.获取协议及版本
        String protocol = request.getProtocol();
        System.out.println(protocol);
        // 8.获取客户机IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
