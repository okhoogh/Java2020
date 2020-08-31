<%--
  Created by IntelliJ IDEA.
  User: DJ
  Date: 2020/8/28
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script>
        onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/day16/checkCodeServlet?" + new Date().getTime();
            }
        }
    </script>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
    <form action="/day16/loginServlet" method="post">
        <table align="center" cellpadding="5">
            <tr>
                <td><label for="username">用户名：</label></td>
                <td><input type="text" placeholder="请输入用户名" name="username" id="username"></td>
            </tr>
            <tr>
                <td><label for="password">密码：</label></td>
                <td><input type="password" placeholder="请输入密码" name="password" id="password"></td>
            </tr>
            <tr>
                <td><label for="checkCode">验证码：</label></td>
                <td><input type="text" placeholder="请输入验证码" name="checkCode" id="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img src="/day16/checkCodeServlet" id="img"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
<%--    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>--%>
<%--    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%></div>--%>
    ${requestScope.cc_error}
    ${requestScope.login_error}
</body>
</html>
