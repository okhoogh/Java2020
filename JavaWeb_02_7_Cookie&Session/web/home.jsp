<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2020/8/28
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if("lastTime".equals(cookie.getName())) {
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    String decode_date = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + decode_date);
     %>
                    <h1>欢迎回来，您上次的访问时间为：<%=decode_date%> </h1>
    <%
                    // 设置新的访问时间
                    Date date = new Date();
                    String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
                    System.out.println("编码前：" + str_date);
                    String encode_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + encode_date);
                    Cookie lastTime = new Cookie("lastTime", encode_date);
                    lastTime.setMaxAge(60 * 60 * 24 * 30);    // 一个月
                    response.addCookie(lastTime);
                    flag = true;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length <= 0 || flag == false) {
    %>
            <h1>您好，欢迎您的首次使用</h1>
    <%
            // 设置访问时间
            Date date = new Date();
            String str_date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
            System.out.println("编码前：" + str_date);
            String encode_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + encode_date);
            Cookie lastTime = new Cookie("lastTime", encode_date);
            lastTime.setMaxAge(60 * 60 * 24 * 30);    // 一个月
            response.addCookie(lastTime);
        }
    %>
</body>
</html>
