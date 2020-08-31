<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>if标签</title>
</head>
<body>
	<%--
		c:if标签
	--%>
	<c:if test="true">
		真
	</c:if>
	<br>
	<%
		// 判断request域中的一个list集合是否为空，如果不为空则显示遍历集合
		List list = new ArrayList();
		list.add("111");
		list.add("222");
		request.setAttribute("list", list);
		request.setAttribute("number", 3);
	%>
	<c:if test="${not empty list}">
		遍历集合...
<%--		<c:forEach ></c:forEach>--%>
	</c:if><br>

	<%--c:if没有else--%>
	<c:if test="${number mod 2 == 1}">
		${number}为奇数...
	</c:if><br>
	<c:if test="${number mod 2 == 0}">
		${number}为偶数...
	</c:if><br>


</body>
</html>
