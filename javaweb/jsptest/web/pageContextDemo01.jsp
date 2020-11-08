<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>
<%
    pageContext.setAttribute("name1","nzhao1");
    request.setAttribute("name2","nzhao2");
    session.setAttribute("name3","nzhao3");
    application.setAttribute("name4","nzhao4");

%>
<%--脚本片段中的代码，会被原封不动的生成JSP.java
要求：这里的代码：必须保证Java语法的正确
--%>
<%
    //从pageContext取出，我们通过寻找的方式来
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5"); //这个name5是不存在的

%>


<%--  使用EL表达式 ${} 取出，注意，EL表达式 ${} 代替的是 <%= %> --%>
<h1>${name1}</h1>
<h1>${name2}</h1>
<h1>${name3}</h1>
<h1>${name4}</h1>
<h1>${name5}</h1>



</body>
</html>
