<%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2020/11/12
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/form" method="get">
    get方式提交<input type="text" name="name">
    <input type="submit">
  </form>

  <form action="/form" method="post">
    post方式提交<input type="text" name="name">
    <input type="submit">
  </form>
  </body>
</html>
