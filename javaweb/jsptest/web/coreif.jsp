<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- jstl需要引入标签库 --%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>if测试</title>
</head>
<body>

<%-- 我们写一个表单，提交到当前页面 --%>
<form action="coreif.jsp" method="post">
<%--  注意这个name，这个name是url传的值，必须是英文，否则会报错500  --%>
    <input type="text" name="username">
    <input type="submit">
</form>

</body>
</html>
