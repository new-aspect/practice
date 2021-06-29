<%--
  Created by IntelliJ IDEA.
  User: 11507
  Date: 2021/3/26
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超市管理系统</title>
    <link type="text/css" rel="stylesheet"  href="css/style.css">
</head>
<!-- body的class="login_bg"调用css/style.css文件的选择器，该选择器调用一张图片作为背景 -->
<body class="login_bg">
    <!-- section的class="loginBox"调用css/style.css文件的选择器，该选择器调用一张图片作为背景 -->
    <section class="loginBox">
        <header class="loginHeader">
            <h3>超市管理系统</h3>
        </header>
    </section>
    <section class="loginCont">
        <%--   这里先写成/login.do，看来这样是错误的，只能写成这样了      --%>
        <form class="loginForm" action="${pageContext.request.contextPath}/login.do" name="actionForm" id="actionForm" method="post">
            <div class="info">${error}</div>
            <div class="inputbox">
                <label for="userCode">用户名：</label>
                <input type="text" id="userCode" name="userCode"/>
            </div>
            <div class="inputbox">
                <label for="userPassword">密码：</label>
                <input type="password" id="userPassword" name="userPassword">
            </div>
            <div class="subBtn">
                <input type="submit" name="提交">
                <input type="reset" name="重置">
            </div>
        </form>
    </section>

</body>
</html>
