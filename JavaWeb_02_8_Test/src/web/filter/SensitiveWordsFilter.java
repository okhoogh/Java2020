package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.创建代理对象
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强getParameter方法
                // 判断是否是该方法
                if (method.getName().equals("getParameter")) {
                    // 增强返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String word : words) {
                            if(value.contains(word)) {
                                value = value.replaceAll(word, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });


        chain.doFilter(proxy_req, resp);
    }

    // 敏感词汇列表
    private List<String> words = new ArrayList<>();
    public void init(FilterConfig config) throws ServletException {
        try {
            // 1.获取敏感词汇真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            // 2.读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath, StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}
