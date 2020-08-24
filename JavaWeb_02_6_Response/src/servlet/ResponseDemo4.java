package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置流的默认编码(可略)
//        response.setCharacterEncoding("utf-8");
        // 告诉浏览器服务器发送的消息体数据编码
        response.setContentType("text/html; charset='utf-8");

        // 1.获取字符输出流
        PrintWriter pw = response.getWriter();
        // 2.输出数据
        pw.write("<h1>hello response</h1>");
        pw.write("你好");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
