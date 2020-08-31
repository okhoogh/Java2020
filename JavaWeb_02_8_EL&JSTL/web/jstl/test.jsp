<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
	<%
		List<User> users = new ArrayList<>();
		users.add(new User("张三", 12, new Date()));
		users.add(new User("李四", 24, new Date()));
		users.add(new User("王五", 36, new Date()));
		request.setAttribute("users", users);
	%>
	<table border="1" align="center" width="500">
		<th>编号</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>生日</th>
		<c:forEach items="${users}" var="u" varStatus="s">
			<c:if test="${s.count % 2 == 0}">
				<tr bgcolor="red">
					<td>${s.count}</td>
					<td>${u.name}</td>
					<td>${u.age}</td>
					<td>${u.birStr}</td>
				</tr>
			</c:if>
			<c:if test="${s.count % 2 != 0}">
				<tr bgcolor="blue">
					<td>${s.count}</td>
					<td>${u.name}</td>
					<td>${u.age}</td>
					<td>${u.birStr}</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>
