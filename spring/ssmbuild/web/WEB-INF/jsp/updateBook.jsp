<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改数据</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>

<%-- BootStrap有一个经典的栅格系统，他可以美化页面，他都包在一个contain的容器中 --%>
<div class="container">

    <%--  首先清除div标签的浮动  --%>
    <div class="row clearfix">
        <div class="page-information">
            <h1 class="center-pill">
                <small>书籍列表 -- 修改书籍</small>
            </h1>
        </div>
    </div>

    <%--   从BootStrap官网全局css页面的表单直接复制的     --%>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
                <div class="form-group">
<%--                    <label>书籍编号</label>--%>
                    <%--   这里input的name必须和后台的名称一样，否者无法传参  --%>
                    <input type="text" name="bookID" class="form-control" value="${beforeBooks.bookID}" hidden>
                </div>
        <div class="form-group">
            <label>书籍名称</label>
            <input type="text" name="bookName" class="form-control" required value="${beforeBooks.bookName}">
        </div>
        <div class="form-group">
            <label>书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" required value="${beforeBooks.bookCounts}">
        </div>
        <div class="form-group">
            <label>书籍描述</label>
            <input type="text" name="detail" class="form-control" required value="${beforeBooks.detail}">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>

</body>
</html>

