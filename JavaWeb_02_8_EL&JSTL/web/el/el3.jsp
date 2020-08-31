<%@ page import="entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>el获取对象数据</title>
</head>
<body>
	<%
		User user = new User();
		user.setName("张三");
		user.setAge(22);
		user.setBirthday(new Date());
		request.setAttribute("u", user);

		ArrayList list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add(user);
		request.setAttribute("s", list);

		Map map = new HashMap();
		map.put("sname", "李四");
		map.put("gender", "男");
		map.put("user", user);
		request.setAttribute("m", map);

	%>

	<h3>el获取对象中的值</h3>
	${requestScope.u.name}<br>
	${u.age}<br>
	${u.birthday}<br>
	${u.birthday.year}<br>
	${u.birthday.month}<br>
	${u.birStr}
<hr>
	<h3>el获取list中的值</h3>
	${s} <br>
	${s[0]} <br>
	${s[1]} <br>
	${s[10]} <br>
	${s[2].name} <br>
<hr>

	<h3>el获取map中的值</h3>
	${m.sname} <br>
	${m["gender"]} <br>
	${m["user"].name} <br>
</body>
</html>
