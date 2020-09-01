package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo7 implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo7来了...");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo7走了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
