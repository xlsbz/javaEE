<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>提示页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
   		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css"/>
	</head>

	<body>
	<!-- 头部 -->
		<%@include file="/jsp/header.jsp" %>
		<div class="container">
				<% String path = request.getContextPath()+"/index.jsp"; %>
				<h1 align="center">${msg },点击<a href="<%=path %>">这里</a>回到主页</h1>
			</div>
</body>

</html>