package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证过滤器
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 0.强制转换成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        // 1.获取资源请求路径
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")
        || uri.contains("/css/") || uri.contains("/font/") || uri.contains("/js/")
        || uri.contains("/checkCodeServlet")) {
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if(user != null) {
                // 登陆了，放行
                chain.doFilter(req, resp);
            } else {
                // 没登陆。跳转到登陆页面
                request.setAttribute("login_error", "您尚未登陆，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
