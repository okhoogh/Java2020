package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 监听servletContextEvent对象创建的,在服务器启动后自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 1.获取servletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        // 2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        // 3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        // 4.加载进内存
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("servletContextEvent被创建了...");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后该方法被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContextEvent被销毁了...");
    }
}
