package web.servlet;

import entity.PageBean;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1.获取参数
        String currentPage = request.getParameter("currentPage");   // 当前页码
        String rows = request.getParameter("rows"); //每页显示条数
        // 2.调用Service查询
        UserService service = new UserServiceImpl();

        // 获得条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        PageBean<User> pb = service.findUserByPage(currentPage, rows, condition);
//        System.out.println(pb);
        // 3.把PageBean存入request
        request.setAttribute("pb", pb);
        request.setAttribute("condition", condition);
        // 4.将PageBean转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
