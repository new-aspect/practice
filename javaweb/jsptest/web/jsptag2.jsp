<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  jsp取出参数  --%>
名称：<%=request.getParameter("name")%>
年龄：<%=request.getParameter("age")%>
</body>
</html>
