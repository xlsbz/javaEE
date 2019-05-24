<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="controller.UsersignS"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="../public/css/apply.css">
	<base href="<%=basePath%>"/>
		<title>报名信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
	
</head>
<body>
		<div class="zjxxbox">
			<div class="zjtxtbox">
			<form action=UsersignS method="post"> 
				<h1 align="center">填写签到信息</h1>
				<div class="list">
					<p class="type">您的学号</p>
					<input type="text" placeholder="请输入您的姓名" name="userId"/>
				</div>
				<div class="list">
					<p class="type">您的姓名</p>
					<input type="text" placeholder="请输入您的电话" name="userName"/>
				</div>
				<div class="list">
					<p class="type">您的性别</p>
					<input type="text" placeholder="请输入您的企业姓名" name="userDeparent"/>
				</div>
				<div class="list">
					<p class="type">您的编号</p>
					<input type="text" placeholder="请输入您的企业姓名" name="userAdress"/>
				</div>
				<div class="list">
					<p class="type">您的学校</p>
					<input type="text" placeholder="请输入您的企业姓名" name="userTime"/>
				</div>
				<div class="list">
					<p class="type">您的学校</p>
					<input type="text" placeholder="请输入您的企业姓名" name="userState"/>
				</div>
				<div class="btns">
				<input type="submit" name="option"  value="addSignUserInfo" class="ui-btn"></input>
				</div>
	
			</form>
					
			</div>
		</div>	
	</body>
</html>