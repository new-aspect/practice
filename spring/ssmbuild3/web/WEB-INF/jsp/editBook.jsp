<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/editBook">
    书籍编号：
    <input type="text" id="bookID" name="bookID" value="${books.bookID}" required><br>
    书籍名称：
    <input type="text" id="bookName" name="bookName" value="${books.bookName}" required><br>
    书籍数量：
    <input type="text" id="bookCounts" name="bookCounts" value="${books.bookCounts}" required><br>
    书籍描述：
    <input type="text" id="detail" name="detail" value="${books.detail}" required><br>
    <input type="submit" name="提交">
</form>


</body>
</html>
