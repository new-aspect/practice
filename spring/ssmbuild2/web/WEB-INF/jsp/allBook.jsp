<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <thead>
    <a href="${pageContext.request.contextPath}/book/toaddPage">添加</a>
    </thead>
    <tr>
        <th>图书名称</th>
        <th>图书数量</th>
        <th>图书描述</th>
        <th> 操作</th>
    </tr>
    <c:forEach items="${beforeBooksList}" var="books">
        <tr>
            <td>${books.bookName}</td>
            <td>${books.bookCounts}</td>
            <td>${books.detail}</td>
            <td>
                <a href="/book/toUpdatePage?bookID=${books.bookID}">更新</a>
                &nbsp;|	&nbsp;
                <a href="/book/deleteBook?bookID=${books.bookID}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
