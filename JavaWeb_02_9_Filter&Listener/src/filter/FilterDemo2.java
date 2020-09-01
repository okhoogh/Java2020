package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 对request对象请求信息增强
        System.out.println("FilterDemo2来了...");
        chain.doFilter(req, resp);
        // 对request对象响应信息增强
        System.out.println("FilterDemo2走了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
