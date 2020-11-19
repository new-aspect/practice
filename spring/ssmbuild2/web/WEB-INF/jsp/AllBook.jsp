<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <th>图书名称</th>
        <th>图书数量</th>
        <th>图书描述</th>
    </tr>
    <c:forEach items="${beforeBooksList}" var="books">
        <tr>
            <td>${books.bookName}</td>
            <td>${books.bookCounts}</td>
            <td>${books.detail}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
