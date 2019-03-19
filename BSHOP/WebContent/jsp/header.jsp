<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="top" id="item4">
	<div class="container clearfix">
		<ul class="clearfix fr">
			<li><a href="${pageContext.request.contextPath }/">首页</a></li>
			<c:if test="${empty user }">
				<li><a href="${pageContext.request.contextPath }/user?method=loginUserUI">登录</a></li>
				<li><a href="${pageContext.request.contextPath }/user?method=registerUserUI">注册</a></li>
			</c:if>
			<c:if test="${not empty user }">
				<li><font color="red">${user.username },您好！</font></li>
				<li><a href="${pageContext.request.contextPath }/user?method=logonUser">注销登录</a></li>
				<li><a href="${pageContext.request.contextPath }/order?method=pageOrderlist&pageNumber=1">我的订单</a></li>
				<li><a href="${pageContext.request.contextPath }/jsp/cart.jsp" style="border: none">我的购物车</a></li>
			</c:if>
		</ul>
	</div>
</div>