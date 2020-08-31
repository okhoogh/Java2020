<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>foreach标签</title>
</head>
<body>
	<%--
		foreach:相当于java代码的for语句
			1.完成重复的操作
				for(int i = 0;i < 10; i++){
				}
				属性:
					begin:开始值
					end:结束值
					var:临时变量
					step:步长
					varStatus :循环状态对象
			2.遍历容器
				List<User> list;
				for(User user : list){
				}
	--%>

	<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
		${i} <h5>${s.index}</h5> <h6>${s.count}</h6><br>
	</c:forEach>


	<%
		List list = new ArrayList();
		list.add("111");
		list.add("222");
		list.add("333");
		request.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="str" varStatus="s">
		${s.index} ${s.count} ${str}<br>
	</c:forEach>
</body>
</html>
