<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax请求的页面</title>
    <%--  script标签必须成对出现  --%>
    <%--  其实也可以直接引入网络的cdn  --%>
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
    <script>
        <%--   如果$.不报错，说明JQuery加载好了 $符号就是JQuery的缩写
               $.ajax() 就是 JQuery.ajax()   --%>
        // $.ajax()
        function a() {
            $.post({
                url: "${pageContext.request.contextPath}/ajaxTest",
                data: {"name": $("#username").val()},
                success: function (data, statue) {
                    //alert(data);
                    //使用控制台输出
                    console.log("data= "+data+" statue "+statue)
                }
            })
        }
    </script>
</head>
<body>
<%-- 失去焦点的时候，发起一个请求（携带信息）到后台 --%>
用户名：<input type="text" id="username" onblur="a()">

</body>
</html>
