<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍展示页面</title>
</head>
<body>
    <!-- 显示标题 -->
    <h1>书籍列表-显示所有书籍</h1>

    <!--  添加书籍的连接  -->
    <a href="${pageContext.request.contextPath}/book/toAddBookPage">添加书籍</a>
    <form action="${pageContext.request.contextPath}/book/search">
        <input type="text" id="search" name="search" placeholder="请输入要查询的内容"/>
        <button type="submit">搜索</button>
    </form>
    <table>
        <thead>
        <tr>
            <th>书籍编号</th>
            <th>书籍名称</th>
            <th>书籍数量</th>
            <th>书籍描述</th>
        </tr>
        </thead>

        <tbody>
            <!--    后端将书籍列表通过model的list取出，            -->
            <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.bookID}</td>
                    <th>${book.bookName}</th>
                    <th>${book.bookCounts}</th>
                    <th>${book.detail}</th>
                    <th><a href="${pageContext.request.contextPath}/book/toUpdateBookPage?bookID=${book.bookID}">编辑</a> </th>
                    <th><a href="${pageContext.request.contextPath}/book/delectBook?bookID=${book.bookID}">删除</a> </th>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
