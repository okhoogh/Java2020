package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    private static Cookie getNewTimeCookie() throws UnsupportedEncodingException {
        // 设置新的访问时间
        Date date = new Date();
        String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
        System.out.println("编码前：" + str_date);
        String encode_date = URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后：" + encode_date);
        Cookie lastTime = new Cookie("lastTime", encode_date);
        lastTime.setMaxAge(60 * 60 * 24 * 30);    // 一个月
        return lastTime;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if("lastTime".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    String decode_date = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + decode_date);
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为：" + decode_date + "</h1>");
                    response.addCookie(getNewTimeCookie());
                    flag = true;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length <= 0 || flag == false) {
            response.getWriter().write("<h1>您好，欢迎您的首次使用</h1>");
            // 设置访问时间
            response.addCookie(getNewTimeCookie());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
