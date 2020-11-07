<%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2020/11/7
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- 在代码中嵌入HTML的新的方式 --%>
<%
    for (int i = 0; i < 5; i++) {
%>
        <h1>hello world  <%=i%></h1>
<%
    }
%>

<%--使用El表达式美化,  El表达式${}   --%>

<% for (int i = 0; i < 5; i++) { %>
   <h1>hello world  ${i} </h1>
<%}%>

</body>
</html>
