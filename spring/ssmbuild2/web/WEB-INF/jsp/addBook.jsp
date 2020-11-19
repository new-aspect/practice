<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/book/addBook" method="get">
        <%--    required表示必须输入    --%>
        书籍名称<input type="text" name="bookName" required>
        书籍数量<input type="text" name="bookCounts" required>
        书籍描述<input type="text" name="detail" required>
        <input type="submit" name="提交">
    </form>

</body>
</html>
