<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍展示页面</title>
</head>
<body>
    <!-- 显示标题 -->
    <h1>书籍列表-显示所有书籍</h1>

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
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
