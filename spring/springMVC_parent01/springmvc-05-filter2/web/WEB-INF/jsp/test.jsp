<%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2020/11/12
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}

<%--JavaScript不能写单独的标签，必须有闭合标签，
不能这样写单独的标签写，如果这样引用资源，是引用不到的--%>
<script src="test.jsp"/>

<%--JavaScript应该这样写闭合标签--%>
<script src="test.jsp"></script>
</body>
</html>
