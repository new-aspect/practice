<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <style>
      a{
        text-decoration: none;//隐藏文本的下划线
      }
      h3{
        width: 180px;
        height: 38px;
        margin: 100px auto;/*外边距100px*/
        text-align: center;/*文本居中*/
        line-hight: 38px ;/*行高和字体一样就可以居中了*/
        background: powderblue;/*背景是蓝色*/
        border-radius: 5px;/* 圆角边框 */
      }
    </style>

  </head>
  <body>

  <h3>
    <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>
  </h3>

  </body>
</html>
