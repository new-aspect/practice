<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>

<%-- BootStrap有一个经典的栅格系统，他可以美化页面，他都包在一个contain的容器中 --%>
<div class="container">

    <%--  首先清除div标签的浮动  --%>
    <div class="row clearfix">
        <div class="page-information">
            <h1 class="center-pill">
                <small>书籍列表 -- 显示所有书籍</small>
            </h1>
        </div>
<%--    添加一个增加的按钮    --%>
        <div class="row">
            <%--   表示占用12格中的四格     --%>
            <div class="col-md-4 colunm">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddPaper">新增书籍</a>
            </div>
            <%--    查询书籍（搜索栏）        --%>
                <div class="col-md-4 colunm">
                    <form action="${pageContext.request.contextPath}/book/queryBookByName" method="get" style="float: right">
                        <%--   plaseholder是输入框默认的名字   --%>
                        <input type="text" name="queryBookName" class="form-controller" placeholder="请输入查询书名">
                        <input type="submit" value="查询" class="btn btn-primary">
                    </form>
                </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="page-information">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍描述</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <tbody>
                    <%--   书记从后端表格查询出来，错后端发过来的list 中取出   --%>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toUpdatePaper?bookID=${book.bookID}">修改</a>
                                <%--   &nbsp; 是空格  --%>
                                &nbsp; | &nbsp;
                                <a href="${pageContext.request.contextPath}/book/delectBook?bookID=${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


</body>
</html>
