<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/addBook">
    书籍编号：
    <input type="text" id="bookID" name="bookID" required><br>
    书籍名称：
    <input type="text" id="bookName" name="bookName" required><br>
    书籍数量：
    <input type="text" id="bookCounts" name="bookCounts" required><br>
    书籍描述：
    <input type="text" id="detail" name="detail" required><br>
    <input type="submit" name="提交">
</form>


</body>
</html>
