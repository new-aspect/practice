<%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2020/11/8
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 转发到index页面 --%>

<%
    //转发到index的方式一，使用pageContext的forward转发
    pageContext.forward("/index.jsp");
    //转发到index的方式二；使用servlet中的request的getRequestDispatcher转发
    //request.getRequestDispatcher("/index.jsp").forward(request,response);
%>

</body>
</html>
