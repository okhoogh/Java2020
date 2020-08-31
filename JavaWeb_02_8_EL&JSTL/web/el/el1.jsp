<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	${3 > 4}
	\${3 > 4}
<hr>

	<h3>算术运算符</h3>
	${3 + 4}<br>
	${3 - 4}<br>
	${3 * 4}<br>
	${3 / 4}<br>
	${3 div 4}<br>
	${3 % 4}<br>
	${3 mod 4}<br>
<hr>

	<h3>比较运算符</h3>
	${3 == 4}<br>
<hr>

	<h3>逻辑运算符</h3>
	${3 > 4 && 3 < 4}<br>
	${3 > 4 and 3 < 4}<br>
<hr>

	<h3>empty运算符</h3>
	<%
		String str = "abc";
		request.setAttribute("str", str);

		List list = new ArrayList();
		request.setAttribute("list", list);

	%>
	${not empty str} <br>
	${not empty list}
</body>
</html>
