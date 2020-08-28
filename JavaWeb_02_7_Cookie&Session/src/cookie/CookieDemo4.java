package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie1 = new Cookie("msg", "hello");
        // 2.设置Cookie存活时间
//        cookie1.setMaxAge(30);  // 将cookie持久化到硬盘，30秒后会自动删除cookie文件
//        cookie1.setMaxAge(-1);      // 关闭浏览器后删除(默认值)
//        cookie1.setMaxAge(0);     // 删除cookie
        // 3.发送Cookie
        response.addCookie(cookie1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
