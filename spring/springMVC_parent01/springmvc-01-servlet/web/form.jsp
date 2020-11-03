<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我们写一个表单的jsp, 用于测试提交form提交请求</title>
</head>
<body>

<form action="/hello" method="get">
    <%--  至少有两个  --%>
    <input type="text" name="method">
    <input type="submit">
</form>


</body>
</html>
