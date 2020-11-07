<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2020/11/7
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 第一种表达式，<%= %>内容里面可以写java代码 --%>
<%= new Date() %>

<br>
<%-- 第二种表达式， <% %> 可以写Java代码 --%>
<%  out.print("一二三"); %>

<br>
<%--  使用 <% %> 可以跨域访问--%>
<% int x = 30; %>
<h1>这是html语句</h1>
<% out.print(x); %>

<br>
<%--  使用 <% %> 包裹HTML语句 --%>
<%
    for (int i = 0; i < 5; i++) {
%>
        <h1>包裹HTML语句测试</h1>
<%
    }
%>

</body>
</html>
