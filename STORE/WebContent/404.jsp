<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>404</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container">
			<!-- 头部 -->
			<%@include file="/jsp/header.jsp" %>
			<div class="container-fluid">
				<% String path = request.getContextPath()+"/index.jsp"; %>
				<h3>您找到页面跑丢了!,点击<a href="<%=path %>">这里</a>回到主页</h3>
			</div>
			<jsp:include page="/jsp/footer.jsp"></jsp:include>
	</div>
</body>

</html>