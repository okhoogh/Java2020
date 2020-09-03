package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置相应的数据格式和编码
//        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        // 1.获取用户名
        String username = request.getParameter("username");
        // 2.检查
        Map<String, Object> map = new HashMap<>();
        if("tom".equals(username)) {
            map.put("userExsit", true);
            map.put("msg", "此用户名太受欢迎,请更换一个");
        } else {
            map.put("userExsit", false);
            map.put("msg", "用户名可用");
        }
        // 3.将map转为json并传回客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
