<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2020/8/28
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("username")%>,欢迎您</h1>
</body>
</html>
