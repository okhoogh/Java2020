package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求头数据: user-agent
        String header = request.getHeader("user-agent");
        System.out.println(header);
        if(header.contains("Chrome")) {
            System.out.println("谷歌浏览器...");
        } else if(header.contains("Edge")){
            System.out.println("Edge浏览器...");
        }
    }
}
