package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求头数据: referer
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if(referer != null) {
            if(referer.contains("day14")) {
                System.out.println("正常访问...");
            } else {
                System.out.println("盗链啊...");
            }
        }
    }
}
