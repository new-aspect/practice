<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    jsp表达式
        作用：用来将程序输出，输出到客户端
        <%= 变量或者表达式%>
 --%>
<%= new Date()%>

<br>

<%-- jsp脚本片段 --%>
<%--  使用<% %>可以直接写Java代码  --%>
<%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
%>

<%--   使用<% %>也是可以做到跨域显示  --%>
<%
    int x = 10;
    out.print(x);
%>
<p>这是一个jsp文档</p>>
<%
    out.print(x);
%>

</body>
</html>
