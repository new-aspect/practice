<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- jsp标签 --%>
<%-- jsp包含某个页面  --%>
<%--<jsp:include page="index.jsp"/>--%>

<%--  jsp转发页面 --%>
<%--<jsp:forward page="hello.jsp"></jsp:forward>--%>


<%--
http://localhost:8080/index.jsp?nane=nzhao&age=12
--%>
<jsp:forward page="/index.jsp">
    <jsp:param name="name" value="nzhoa"/>
    <jsp:param name="age" value="12"/>
</jsp:forward>

</body>
</html>
