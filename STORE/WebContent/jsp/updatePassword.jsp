<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>修改密码</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container">
			<!-- 头部 -->
			<%@include file="/jsp/header.jsp" %>
				<form action="user" method="post" class="form-inline" style="margin-left:2%;">
					  <!-- 隐藏域传参 -->
					  <input type="hidden" name="method" value="updatePassword">
					  <input type="hidden" name="userid" value="${user.uid }">
					  <div class="form-group">
					    <label for="exampleInputPassword1">原密码</label>
					    <input type="password" class="form-control" size="60" name="oldPassword" id="exampleInputEmail1" placeholder="原密码">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">新密码</label>
					    <input type="password" class="form-control" name="newPassword" id="exampleInputPassword1" placeholder="新密码">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">再输一次</label>
					    <input type="password" class="form-control" id="exampleInputPassword2" placeholder="新密码">
					  </div>
  					  <input type="submit" value="确认修改">
				</form>
				
			<!-- 尾部 -->
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
</body>

</html>