package servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        // 获取文件的服务器路径
        // 1.web目录下的资源访问
        String realPath1 = servletContext.getRealPath("/b.txt");
        System.out.println(realPath1);
        // 2.WEB-INF目录下的资源访问
        String realPath2 = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath2);
        // 3.src目录下的资源访问
        String realPath3 = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
