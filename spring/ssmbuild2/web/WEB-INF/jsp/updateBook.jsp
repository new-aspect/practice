<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/book/updateBook" method="get">
    <%--    required表示必须输入    --%>
    <input name="bookID" hidden="hidden" value="${beforeBook.bookID}">
    书籍名称<input type="text" name="bookName" required value="${beforeBook.bookName}">
    书籍数量<input type="text" name="bookCounts" required value="${beforeBook.bookCounts}">
    书籍描述<input type="text" name="detail" required value="${beforeBook.detail}">
    <input type="submit" name="提交">
</form>

</body>
</html>