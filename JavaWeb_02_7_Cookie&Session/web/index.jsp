<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2020/8/26
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    System.out.println("hello world");
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>
  </body>
</html>
