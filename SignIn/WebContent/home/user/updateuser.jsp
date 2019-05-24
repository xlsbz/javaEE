<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import ="controller.*"%>
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
		<title>修改信息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
	
</head>
<body>
		<div class="zjxxbox">
			<div class="zjtxtbox">
			<form action=UserS method="post"> 
				<h1 align="center">修改个人信息</h1>
				<div class="list">
					<p class="type">您的账号</p>
					<input type="text" placeholder="禁止修改账号" name="wiID"/>
				</div>
				<div class="list">
					<p class="type">所属管理员</p>
					<input type="text" placeholder="禁止修改所属管理员" name="admID"/>
				</div>
				<div class="list">
					<p class="type">您的姓名</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiName"/>
				</div>
				<div class="list">
					<p class="type">您的性别</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiSex"/>
				</div>
				<div class="list">
					<p class="type">您的状态</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiGrade"/>
				</div>
				<div class="list">
					<p class="type">您的密码</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiPsd"/>
				</div>
				<div class="list">
					<p class="type">您的部门</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiAddress"/>
				</div>
				<div class="list">
					<p class="type">你的电话</p>
					<input type="text" placeholder="请输入您的企业姓名" name="wiPhone"/>
				</div>
			
				<div class="list">
					<p class="type">您的生日</p>
					<input type="text" placeholder="请输入您的备注内容" name="wiBorthday"/>
				</div>
					
				<div class="list">
					<p class="info">建议不要修改账号和所属管理员</p>
				</div>
				<div class="btns">
				<input type="submit" name="option"  value="updateUserInfo" class="ui-btn"></input>
				</div>
	
			</form>
					
			</div>
		</div>	
	</body>
</html>