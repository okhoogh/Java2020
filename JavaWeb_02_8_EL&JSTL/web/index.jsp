<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%
      List arrayList = new ArrayList();
//      int i = 3/ 0;
    %>

  <%
	  pageContext.setAttribute("msg", "hello");
  %>

  <%=pageContext.getAttribute("msg")%>


  </body>
</html>
