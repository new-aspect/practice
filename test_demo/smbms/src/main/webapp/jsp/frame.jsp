<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
    <img class="wColck" src="${pageContext.request.contextPath}/images/clock.jpg" alt=""/>
    <div class="wFont">
        <h2>${userSession.userName }</h2>
        <p>欢迎来到超市订单管理系统!</p>
        <form action="${pageContext.request.contextPath}/jsp/logout.do">
            <input type="submit" name="登出">
        </form>
    </div>
</div>
<%@include file="/jsp/common/foot.jsp"%>
